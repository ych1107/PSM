package com.ujiuye.info.controller;

import com.github.pagehelper.PageInfo;
import com.ujiuye.emp.bean.Employee;
import com.ujiuye.emp.service.ArchivesService;
import com.ujiuye.info.bean.Email;
import com.ujiuye.info.service.EmailService;
import com.ujiuye.jobs.JobEmail;
import com.ujiuye.utils.MapUtils;
import com.ujiuye.utils.ResultEntity;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-04 16:45
 **/
@Controller
@RequestMapping("/info")
public class EmailController {

    @Autowired
    private ArchivesService archivesService;
    @Autowired
    private JavaMailSenderImpl JavaMailSenderImpl;
    @Autowired
    private EmailService emailService;

    //导出excel
    @RequestMapping(value = "/excels",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> excels(){
        Map<String,Object> map = new HashMap<>();
        List<Email> list =emailService.getEmailAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Workbook wb = new HSSFWorkbook();
        Sheet sheet =wb.createSheet("sheet1");
        Row row =sheet.createRow(0);
        row.createCell(0).setCellValue("序号");
        row.createCell(1).setCellValue("标题");
        row.createCell(2).setCellValue("内容");
        row.createCell(3).setCellValue("收件人");
        row.createCell(4).setCellValue("发送时间");
        for (int i = 0; i <list.size() ; i++) {
            Row row1 =sheet.createRow(i+1);
            Email email = list.get(i);
            row1.createCell(0).setCellValue(email.getId());
            row1.createCell(1).setCellValue(email.getTitle());
            row1.createCell(2).setCellValue(email.getContent());
            row1.createCell(3).setCellValue(email.getEname());
            row1.createCell(4).setCellValue(email.getSendtime());
        }
        try {
            wb.write(new FileOutputStream(new File("C:\\Users\\19766\\Desktop\\email.xls")));
            map.put("result",200);
            map.put("success","导入成功");
        } catch (IOException e) {
            e.printStackTrace();
            map.put("result",500);
        }finally {
            if (wb!=null){
                try {
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  map;
    }
    //批量删除收件人
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> batchdel(@RequestParam("ids[]") Integer[] ids){
        Map<String,Object> map = new HashMap<>();
        System.out.println(Arrays.toString(ids));
        boolean b = emailService.batchdel(ids);
        if(b){
            map.put("status", 200);
            map.put("message", "删除成功");
        }else{
            map.put("message", "删除失败");
        }
        return map;
    }
    @RequestMapping("/saveInfo")
    public String saveInfo(Email email, MultipartFile file, HttpSession session){
        //通过档案表获取个人email地址
        String emailAddress = archivesService.getEmailByEid(email.getEmpFk());
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/upload");
        File directory = new File(realPath);

        if(!directory.exists()){
            directory.mkdirs();
        }
        String  fileName = UUID.randomUUID().toString().replaceAll("-", "")+file.getOriginalFilename();
        //FASTDFS文件服务器:
        //将上传的文件保存到本地服务器里面
        try {
            //file.transferTo(new File(realPath+"/"+fileName));
            // IOUtils.copy(file.getInputStream(),new FileOutputStream(new File(realPath+"/"+fileName)));
            IOUtils.copy(file.getInputStream(), new FileOutputStream(new File(realPath + "/" + fileName)));
            email.setPath(fileName);
            //创建jobDetail对象，指定对象的名称和组
            JobDetail jobDetail = JobBuilder.newJob(JobEmail.class).withIdentity("job1", "grop1").build();
            //将需要传递的参数设置给Jobemail中
            JobDataMap jobDataMap = jobDetail.getJobDataMap();
            jobDataMap.put("email", email);
            //发送邮件的对象
            jobDataMap.put("JavaMailSenderImpl", JavaMailSenderImpl);
            jobDataMap.put("emailAddress",emailAddress);
            jobDataMap.put("file",file);
            jobDataMap.put("fileAddress",realPath+"/"+fileName);
            long l = email.getSendtime().getTime()+60000l;
            Date date = new Date(l);
            //创建simpletrigger对象，指定对象的名称和组名，设置任务的宠物执行间隔、重复执行次数、启动时间
            SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger().withIdentity("trigger1","grop1")
                    /*.withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(10)//重复间隔
                            .withRepeatCount(10))*/
                    .startAt(date).build();//重复次数
            //创建任务管理器scheduler对象
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            jobDataMap.put("sche", scheduler);
            //为scheduler对象新增job以及simpletrigger对象
            scheduler.scheduleJob(jobDetail, trigger);

            //启动定时任务管理器
            scheduler.start();

            Employee employe = (Employee) session.getAttribute("loginUser");

            email.setEname(employe.getEname());
            emailService.saveInfo(email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "message";
    }
    /**
     * @Author Mr.C
     * @Description  异步请求的分页以及查询
     * @Date 2019/12/3 21:37
     * @Param [request, pageNum, search_cid]
     * @return com.ujiuye.utils.ResultEntity
     **/
    @RequestMapping("/seachBypage")
    @ResponseBody
    public ResultEntity seachBypage(HttpServletRequest request, String pageNum){
        String requestURI = request.getRequestURI();
        Map<String, Object> map = WebUtils.getParametersStartingWith(request, "search_");

        System.out.println(map);
        Map<String, Object> map1 = MapUtils.paramMapTomybatisMap(map);
        String queryStr = MapUtils.parseParamMapToQueryStr(map);
        PageInfo<Email> page = emailService.getAll(map1,pageNum);

        return ResultEntity.getResultEntity().put("page",page).put("queryStr",queryStr).put("requestURI",requestURI);
    }

}

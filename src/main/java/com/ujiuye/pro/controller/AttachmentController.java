package com.ujiuye.pro.controller;

import com.ujiuye.pro.bean.Attachment;
import com.ujiuye.pro.service.AttachmentService;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-11-29 18:52
 **/
@Controller
@RequestMapping("/attach")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    //导出excel

    @RequestMapping(value = "/excel",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getExcel(){
        List<Attachment> list = attachmentService.getAll();
        Map<String,Object> map=new HashMap();
        Workbook wb=new HSSFWorkbook();
        Sheet sheet1 = wb.createSheet("sheet1");
        Row row = sheet1.createRow(0);
        row.createCell(0).setCellValue("序号");
        row.createCell(1).setCellValue("附件名称");
        row.createCell(2).setCellValue("所属项目");
        row.createCell(3).setCellValue("附件个数");
        row.createCell(4).setCellValue("附件描述");
        row.createCell(4).setCellValue("上传的附件名称");

        try {
            for (int i = 0; i < list.size(); i++) {
                Attachment attachment = list.get(i);
                Row row1 = sheet1.createRow(i+1);
                row1.createCell(0).setCellValue(i+1);
                row1.createCell(1).setCellValue(attachment.getId());
                row1.createCell(2).setCellValue(attachment.getAttname());
                row1.createCell(3).setCellValue(attachment.getProject().getPname());
                row1.createCell(4).setCellValue(attachment.getCount());
                row1.createCell(4).setCellValue(attachment.getAttdis());
                row1.createCell(4).setCellValue(attachment.getPath());
            }
            wb.write(new FileOutputStream(new File("C:\\Users\\19766\\Desktop\\attachment.xls")));
            map.put("result",200);
            map.put("success","导出成功");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (wb!=null){
                try {
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }


    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveInfo(Attachment attachment , MultipartFile file, HttpSession session){
        Map<String, Object> map = new HashMap<>();
        String filename = file.getOriginalFilename();
        String realPath = session.getServletContext().getRealPath("/upload");
        File file1 = new File(realPath);
        if (!file1.exists()){
            file1.mkdirs();
        }
        InputStream  inputStream = null;
        OutputStream outputStream = null;
        filename= UUID.randomUUID().toString().replaceAll("-", "")+filename;
        //将上传的文件保存到服务器中
        try {
            inputStream = file.getInputStream();
            outputStream = new FileOutputStream(new File("F:\\upload" + "/" + filename));
            IOUtils.copy(inputStream,outputStream);
            attachment.setPath(filename);
            attachmentService.saveInfo(attachment);
            map.put("message", "添加成功");
        } catch (IOException e) {
            e.printStackTrace();
            map.put("message", "添加失败");
        }finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
        }
        return map;
    }
    @RequestMapping("/list")
    @ResponseBody
    public List<Attachment> getAll(){
        List<Attachment> list = attachmentService.getAll();
        return list;
    }
    @RequestMapping("/batchdel")
    @ResponseBody
    public Map<String,Object> batchdel(@RequestParam("ids[]")Integer[] ids){
        Map<String,Object> map = new HashMap<>();
        boolean b = attachmentService.batchdel(ids);
        if (b){
            map.put("message", "删除成功");
        }else{
            map.put("message", "删除失败");
        }
        return map;
    }
    @RequestMapping(value = "/getOne")
    @ResponseBody
    public Attachment getOne(Integer id){
        Attachment attachment = attachmentService.getOne(id);
        return attachment ;
    }
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> edit(Attachment attachment , MultipartFile file, HttpSession session){
        System.out.println(attachment);
        Map<String, Object> map = new HashMap<>();
        if (file!=null){
            String filename = file.getOriginalFilename();
            String realPath = session.getServletContext().getRealPath("/upload");
            File file1 = new File(realPath);
            if (!file1.exists()){
                file1.mkdirs();
            }
            InputStream  inputStream = null;
            OutputStream outputStream = null;
            filename= UUID.randomUUID().toString().replaceAll("-", "")+filename;
            //将上传的文件保存到服务器中
            try {
                inputStream = file.getInputStream();
                outputStream = new FileOutputStream(new File("F:\\upload" + "/" + filename));
                IOUtils.copy(inputStream,outputStream);
                attachment.setPath(filename);

            } catch (IOException e) {
                e.printStackTrace();
                map.put("message", "修改失败");
            }finally {
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(outputStream);
            }
        }
        attachmentService.edit(attachment);
        map.put("message", "修改成功");
        return map;
    }
    @RequestMapping("/search")
    @ResponseBody
    public List<Attachment> search(Integer cid, String keyword, Integer orderby){
        List<Attachment> list = attachmentService.search(cid,keyword,orderby);
        return list;
    }
}

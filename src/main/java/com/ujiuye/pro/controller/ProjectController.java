package com.ujiuye.pro.controller;

import com.ujiuye.pro.bean.Project;
import com.ujiuye.pro.service.ProjectService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-11-27 16:05
 **/
@Controller
@RequestMapping("/pro")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public  List<Project> getAll(){
        List<Project> list = projectService.getAll();
        return list;
    }

    //从数据库导出excel表格
    @RequestMapping(value = "/excel",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> exportExcel(){
        List<Project> list = projectService.getAll();
        Map<String,Object> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("sheet1");
        Row row = sheet.createRow(0);
        Cell[] cell = new HSSFCell[10];
        for (int i = 0; i <cell.length ; i++) {
                cell[i]=row.createCell(i);
        }
        cell[0].setCellValue("序号");
        cell[1].setCellValue("项目名称");
        cell[2].setCellValue("客户公司名称");
        cell[3].setCellValue("客户方负责人");
        cell[4].setCellValue("项目经理");
        cell[5].setCellValue("开发人员数");
        cell[6].setCellValue("开始时间");
        cell[7].setCellValue("立项时间");
        cell[8].setCellValue("计划完成时间");
        cell[9].setCellValue("状态");
        for (int i = 0; i <list.size(); i++) {
            Project project = list.get(i);
            Row row1 = sheet.createRow(i + 1);
            Cell[] cell1 = new HSSFCell[10];
            for (int j = 0; j <cell1.length ; j++) {
                cell1[j]=row1.createCell(j);
            }
            cell1[0].setCellValue(i+1);
            cell1[1].setCellValue(project.getPname());
            cell1[2].setCellValue(project.getCustomer().getComname()); //因为数据库存得int类型 需要关联客户表去客户表中找。
            cell1[3].setCellValue(project.getComper());
            cell1[4].setCellValue(project.getEmployee().getEname());//员工表的ename就是项目表的外键。员工表的ename就是项目表的项目经理。
            cell1[5].setCellValue(project.getEmpcount());
            cell1[6].setCellValue(sdf.format(project.getStarttime()));
            cell1[7].setCellValue(sdf.format(project.getBuildtime()));
            cell1[8].setCellValue(sdf.format(project.getEndtime()));
            cell1[9].setCellValue("进行中");
        }
        try {
            wb.write(new FileOutputStream(new File("C:\\Users\\19766\\Desktop\\project.xls")));
            map.put("result",200);
            map.put("success","导入成功");
        } catch (IOException e) {
            e.printStackTrace();
            //失败的话页面回显函数使用
            map.put("result",500);
        }finally {
            try {
                if (wb!=null){
                    wb.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  map;
    }


    @RequestMapping("/saveInfo")
    @ResponseBody
    public String saveInfo(Project project,String comnamewithId){
        String s = comnamewithId.split(",")[1];
        project.setComname(Integer.valueOf(s));
        System.out.println(project);
        int i = projectService.saveInfo(project);
        String msg="";
        if(i>0){
            msg="200";
        }
        return msg;
    }
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> batchdel(@RequestParam("ids[]") Integer[] ids){
        Map<String,Object> map = new HashMap<>();
        System.out.println(Arrays.toString(ids));
        boolean b = projectService.batchdel(ids);
        if(b){
            map.put("status", 200);
            map.put("message", "删除成功");
        }else{
            map.put("message", "删除失败");
        }
        return map;
    }
    @RequestMapping(value = "/getOne")
    @ResponseBody
    public Project getOne(Integer id){
        Project project = projectService.getOne(id);
        return project ;
    }
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> edit(@RequestBody Project project){
        Map<String,Object> map = new HashMap<>();
        System.out.println("sas"+project);
        boolean b = projectService.edit(project);
        if(b){
            map.put("message", "修改成功");
        }else{
            map.put("message", "修改失败");
        }
        return map;
    }
    @RequestMapping("/search")
    @ResponseBody
    public List<Project> search(Integer cid,String keyword,Integer orderby){
        System.out.println(123);
        System.out.println(cid);
        System.out.println(keyword);
        System.out.println(orderby);
        List<Project> list = projectService.search(cid,keyword,orderby);
        return list;
    }

}

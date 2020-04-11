package com.ujiuye.pro.controller;

import com.ujiuye.pro.bean.Analysis;
import com.ujiuye.pro.bean.Project;
import com.ujiuye.pro.service.AnalysisService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-11-28 19:02
 **/
@Controller
@RequestMapping("/pneed")
public class AnalysisController {
    @Autowired
    private AnalysisService analysisService;


    //导出excel
    @RequestMapping(value = "/excel",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> exportExcel(){
        List<Analysis> all = analysisService.getAll();
        Map<String,Object> map = new HashMap<>();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Workbook wb = new HSSFWorkbook();
        Sheet sheet=wb.createSheet("sheet1");
        Row row = sheet.createRow(0);
        Cell[] cells = new HSSFCell[5];
        for (int i = 0; i <cells.length ; i++) {
            cells[i]=row.createCell(i);
        }
        cells[0].setCellValue("序号");
        cells[1].setCellValue("标题");
        cells[2].setCellValue("项目名称");
        cells[3].setCellValue("添加时间");
        cells[4].setCellValue("修改时间");
        for (int i = 0; i <all.size() ; i++) {
            Analysis analysis = all.get(i);
            Row row1 =sheet.createRow(i+1);
            row1.createCell(0).setCellValue(i+1);
            row1.createCell(1).setCellValue(analysis.getTitle());
            row1.createCell(2).setCellValue(analysis.getProname());
            row1.createCell(3).setCellValue(analysis.getAddtime());
            row1.createCell(4).setCellValue(analysis.getUpdatetime());
        }
        try {
            wb.write(new FileOutputStream(new File("C:\\Users\\19766\\Desktop\\analysis.xls")));
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
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Analysis> getAll(){
        List<Analysis> list = analysisService.getAll();
        return list;
    }
    @RequestMapping(value = "/getOne",method = RequestMethod.GET)
    @ResponseBody
    public Analysis getOne(Integer id){
        Analysis analysis =  analysisService.getOne(id);
        return analysis;
    }
    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveInfo(Analysis analysis,String pronameAndid){
        String proname = pronameAndid.split(",")[0];
        String id = pronameAndid.split(",")[1];
        analysis.setProname(proname);
        analysis.setId(Integer.valueOf(id));
        Map<String,Object> map = new HashMap<>();
        boolean b = analysisService.saveInfo(analysis);
        if(b){
            map.put("message", "添加成功");
        }else{
            map.put("message", "添加失败");
        }
        return map;
    }
    @RequestMapping("/getPro")
    @ResponseBody
    public List<Project> getPro(){
        List<Project> list= analysisService.getPro();
        return list;
    }
    @RequestMapping("/batchdel")
    @ResponseBody
    public Map<String,Object> batchdel(@RequestParam("ids[]")Integer[] ids){
        Map<String,Object> map = new HashMap<>();
        boolean b = analysisService.batchdel(ids);
        if (b){
            map.put("message", "删除成功");
        }else{
            map.put("message", "删除失败");
        }
        return map;
    }
    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Object> update(Analysis analysis) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(analysis);
        boolean b =analysisService.update(analysis);
        if (b){
            map.put("message", "修改成功");
        }else{
            map.put("message", "修改失败");
        }
        return map;
    }
    @RequestMapping("/search")
    @ResponseBody
    public List<Project> search(Integer cid,String keyword,Integer orderby){
        System.out.println(cid+keyword);
        System.out.println(keyword);
        List<Project> list = analysisService.search(cid,keyword,orderby);

        return list;
    }
}


package com.ujiuye.pro.controller;

import com.ujiuye.pro.bean.Module;
import com.ujiuye.pro.service.ModuleService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
 * @create: 2019-11-30 14:18
 **/
@Controller
@RequestMapping("/module")
public class ModuleControler {
    @Autowired
    private ModuleService moduleService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Module> getAll(){
        List<Module> list =  moduleService.getAll();
        return list;
    }

    //导出excel
    @RequestMapping(value = "/excel",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> exportExcel(){
        List<Module> all = moduleService.getAll();
        Map<String,Object> map = new HashMap<>();
        Workbook wb = new HSSFWorkbook();
        Sheet sheet1 = wb.createSheet("sheet1");
        Row row = sheet1.createRow(0);
        row.createCell(0).setCellValue("序号");
        row.createCell(1).setCellValue("模块名称");
        row.createCell(2).setCellValue("需求名称");
        row.createCell(3).setCellValue("项目名称");
        row.createCell(4).setCellValue("优先级");
        row.createCell(5).setCellValue("添加时间");
        row.createCell(6).setCellValue("修改时间");
        for (int i = 0; i <all.size() ; i++) {
            Module module = all.get(i);
            Row row1 = sheet1.createRow(i+1);
            row1.createCell(0).setCellValue(module.getId());
            row1.createCell(1).setCellValue(module.getModname());
            row1.createCell(2).setCellValue(module.getAnalysis().getTitle());
            row1.createCell(3).setCellValue(module.getAnalysis().getProname());
            row1.createCell(4).setCellValue(module.getLevel());
            row1.createCell(5).setCellValue(module.getAnalysis().getAddtime());
            row1.createCell(6).setCellValue(module.getAnalysis().getUpdatetime());
        }
        try {
            wb.write(new FileOutputStream(new File("C:\\Users\\19766\\Desktop\\module.xls")));
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
        return  map;
    }
    @RequestMapping("/saveInfo/{paid}")
    @ResponseBody
    public Map<String,Object> saveInfo(Module module,@PathVariable("paid") String paid){
        Map<String,Object> map = new HashMap<String, Object>();
        System.out.println(paid);
        System.out.println(module);
        String proname = paid.split(",")[1];
        module.setProname(proname);
        boolean b = moduleService.saveInfo(module);
        if(b){
            map.put("message", "添加成功");
        }else{
            map.put("message", "添加失败");
        }

       return map;
    }
    @RequestMapping(value = "/getOne",method = RequestMethod.GET)
    @ResponseBody
    public Module getOne(Integer id){
        Module module = moduleService.getOne(id);
        Integer aid = module.getAnalysisFk();
        return module;
    }
    @RequestMapping("/batchdel")
    @ResponseBody
    public Map<String,Object> batchdel(@RequestParam("ids[]")Integer[] ids){
        Map<String,Object> map = new HashMap<>();
        boolean b = moduleService.batchdel(ids);
        if (b){
            map.put("message", "删除成功");
        }else{
            map.put("message", "删除失败");
        }
        return map;
    }
    @RequestMapping("/edit/{paid}")
    @ResponseBody
    public Map<String,Object> edit(Module module,@PathVariable("paid") String paid){
        Map<String,Object> map = new HashMap<>();

        String proname = paid.split(",")[1];
        module.setProname(proname);
        boolean b = moduleService.edit(module);
        if(b){
            map.put("message", "修改成功");
        }else{
            map.put("message", "修改失败");
        }

        return map;
    }
    @RequestMapping("/search")
    @ResponseBody
    public List<Module> search(Integer cid, String keyword, Integer orderby){
        List<Module> list = moduleService.search(cid,keyword,orderby);
        return list;
    }
    @RequestMapping("/models")
    @ResponseBody
    public List<Module> models(Integer cid){
        System.out.println(cid);
        List<Module> list = moduleService.models(cid);
        System.out.println(list);
        return list;
    }
}

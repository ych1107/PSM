package com.ujiuye.pro.controller;

import com.ujiuye.pro.bean.Functions;
import com.ujiuye.pro.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-11-30 18:40
 **/
@Controller
@RequestMapping("/fun")
public class FunctionController {

    @Autowired
    private FunctionService functionService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Functions> getAll(){
        List<Functions> list = functionService.getAll();
        return list;
    }
    @RequestMapping("/saveInfo/{pronameandid}")
    @ResponseBody
    public Map<String,Object> saveInfo(Functions functions ,@PathVariable("pronameandid") String pronameandid){
        Map<String,Object> map = new HashMap<String, Object>();
        String s = pronameandid.split(",")[1];
        functions.setProname(s);
        boolean b = functionService.saveInfo(functions);
        if (b){
            map.put("message", "添加成功");
        }else{
            map.put("message", "添加失败");
        }
        return map;
    }

    @RequestMapping("/batchdel")
    @ResponseBody
    public Map<String,Object> batchdel(@RequestParam("ids[]")Integer[] ids){
        Map<String,Object> map = new HashMap<>();
        boolean b = functionService.batchdel(ids);
        if (b){
            map.put("message", "删除成功");
        }else{
            map.put("message", "删除失败");
        }
        return map;
    }

    @RequestMapping(value = "/getOne",method = RequestMethod.GET)
    @ResponseBody
    public Functions getOne(Integer id) {
        Functions functions = functionService.getOne(id);
        return functions;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Map<String,Object> edit(Functions functions){
        Map<String,Object> map = new HashMap<>();

        boolean b = functionService.edit(functions);
        if(b){
            map.put("message", "修改成功");
        }else{
            map.put("message", "修改失败");
        }

        return map;
    }
    @RequestMapping("/search")
    @ResponseBody
    public List<Functions> search(Integer cid, String keyword, Integer orderby){
        List<Functions> list = functionService.search(cid,keyword,orderby);
        return list;
    }
    @RequestMapping("/getFuncs")
    @ResponseBody
    public List<Functions> getFuncs(Integer id){
        List<Functions> list = functionService.getFuncs(id);

        return list;
    }
}

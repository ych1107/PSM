package com.ujiuye.datacollect.controller;


import com.ujiuye.datacollect.bean.Datacollect;
import com.ujiuye.datacollect.service.DatacollectService;
import com.ujiuye.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/dc")
@Controller
public class DatacollectController {

    @Autowired
    private DatacollectService datacollectService;

    @RequestMapping(value = "/addOne",method = RequestMethod.POST)
    public ModelAndView addOne(Datacollect datacollect){
        ModelAndView modelAndView = new ModelAndView("main");
        datacollectService.addOne(datacollect);
        return  modelAndView;
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity getAll(){
        List<Datacollect> list=datacollectService.getAll();
        return ResultEntity.getResultEntity().put("list",list);
    }
}

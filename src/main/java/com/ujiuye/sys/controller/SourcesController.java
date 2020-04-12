package com.ujiuye.sys.controller;

import com.ujiuye.sys.bean.Sources;
import com.ujiuye.sys.service.SourcesService;
import com.ujiuye.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-06 11:27
 **/
@Controller
@RequestMapping("/sour")
public class SourcesController {

    @Autowired
    private SourcesService sourcesService;
    @RequestMapping(value = "/jsonList",method = RequestMethod.GET)
    @ResponseBody
    public List<Sources> getSourceJsoList(){
        List<Sources> list = sourcesService.getSourceJsoList(0);
        queryChildren(list.get(0));
        return list;
    }

    private void queryChildren(Sources sources) {
        Integer id = sources.getId();
        List<Sources> sourceJsoList = sourcesService.getSourceJsoList(id);
        for (Sources sources1 : sourceJsoList) {
            queryChildren(sources1);

        }
        sources.setChildren(sourceJsoList);

    }

    @RequestMapping("/saveInfo")
    public String saveInfo(Sources sources) {
        sourcesService.saveInfo(sources);
        return "pm";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultEntity delete(Integer id) {
        sourcesService.delete(id);
        return ResultEntity.getResultEntity();
    }
    @RequestMapping("/getOne/{sid}")
    @ResponseBody
    public Sources getOne(@PathVariable("sid") Integer id) {
        Sources sources = sourcesService.getOne(id);

        return sources;
    }
    @RequestMapping("/edit")
    public String edit(Sources sources) {
        sourcesService.edit(sources);
        return "pm";
    }
}

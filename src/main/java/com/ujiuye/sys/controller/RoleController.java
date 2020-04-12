package com.ujiuye.sys.controller;

import com.ujiuye.sys.bean.Role;
import com.ujiuye.sys.service.RoleService;
import com.ujiuye.sys.service.RoleSourcesService;
import com.ujiuye.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-06 19:53
 **/
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Resource
    private RoleSourcesService roleSourcesService;

    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity saveInfo(Role role, @RequestParam("ids[]") Integer[] ids) {
        System.out.println(Arrays.toString(ids));
        int i = roleService.saveInfo(role);
        System.out.println(i);
        roleSourcesService.batchInsert(i, ids);
        return ResultEntity.getResultEntity();
    }
    @RequestMapping("/getAll")
    @ResponseBody
    public ResultEntity getAll(){
        List<Role> list = roleService.getAll();
        return ResultEntity.getResultEntity().put("list", list);
    }
 }

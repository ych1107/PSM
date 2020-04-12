package com.ujiuye.usual.controller;

import com.ujiuye.emp.bean.Employee;
import com.ujiuye.usual.bean.Forumpost;
import com.ujiuye.usual.service.ForumPostService;
import com.ujiuye.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-05 19:31
 **/
@Controller
@RequestMapping("/forumpost")
public class ForumPostController {

    @Autowired
    private ForumPostService forumPostService;
    @RequestMapping("/saveInfo")
    @ResponseBody
    public ResultEntity saveInfo(Forumpost forumpost, HttpSession session) {
        Employee employee = (Employee)session.getAttribute("loginUser");
        Integer eid = employee.getEid();
        forumpost.setEmpFk3(eid);

        forumPostService.saveInfo(forumpost);
        return ResultEntity.getResultEntity();
    }
}

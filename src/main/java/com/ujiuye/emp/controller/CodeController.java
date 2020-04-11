package com.ujiuye.emp.controller;

import com.ujiuye.utils.ValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-02 17:58
 **/
@Controller
@RequestMapping("/code")
public class CodeController {
    @RequestMapping(value="getCode")
    public void getCode(@RequestParam(value = "time") String time, HttpServletRequest request, HttpServletResponse response) {
        ValidateCode code = new ValidateCode(100, 30, 4, 30, 25, "codeImg");
        code.getCode(request, response);

    }
}

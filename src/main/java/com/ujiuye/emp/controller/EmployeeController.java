package com.ujiuye.emp.controller;

import com.ujiuye.emp.bean.Employee;
import com.ujiuye.emp.service.EmployeeService;
import com.ujiuye.sys.bean.Sources;
import com.ujiuye.sys.service.SourcesService;
import com.ujiuye.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-11-27 17:58
 **/
@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SourcesService sourcesService;

    @RequestMapping(value = "/jsonListemp",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> JsonListemp(){
        List<Employee> list =   employeeService.JsonListemp();
        return list;
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAll(){
        List<Employee> list =   employeeService.getAll();
        return list;
    }

    @RequestMapping("/login")
    public String login(Employee employee, String code, HttpSession session, RedirectAttributes attributes){
        String  codeImg = (String) session.getAttribute("codeImg");
        session.removeAttribute("codeImg");
        //验证验证码是否正确
        if(!codeImg.equalsIgnoreCase(code)){
            attributes.addFlashAttribute("message", "验证码错误");
            return "redirect:/login";
        }
        //验证用户名和密码是否错误
        Employee employee1 = employeeService.search(employee.getUsername());
        if (employee1==null||!(employee.getPassword().equals(employee1.getPassword()))){
            attributes.addFlashAttribute("errormsg", "账号或密码错误");
            return "redirect:/login";
        }else{
            session.setAttribute("loginUser", employee1);
            List<Sources> sources = sourcesService.getSources(employee1.getEid());
            session.setAttribute("sources", sources);
            return "redirect:/index.jsp";
        }
    }

    @RequestMapping("/llu")
    @ResponseBody
    public  Employee lookLoginUser(HttpSession session){
        Employee emp = (Employee) session.getAttribute("loginUser");
        return emp;
    }

    @RequestMapping(value = "/others",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getOthers(HttpSession session){
        Employee employee =(Employee) session.getAttribute("loginUser");
        Integer eid = employee.getEid();
        List<Employee> list = employeeService.getOthers(eid);
        return list;
    }


    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity saveInfo(Employee employee){
        employeeService.saveInfo(employee);
        return ResultEntity.getResultEntity();
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> logout(HttpSession session){
        Map<String, Object> map = new HashMap<>();
        session.invalidate();
        map.put("status", 200);
        map.put("message", "退出成功");
        return map;
    }
    @RequestMapping(value = "/changPwd",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> changPwd(HttpSession session,Employee employee){
        Map<String, Object> map = new HashMap<>();
        employeeService.changPwd(employee);
        session.invalidate();

        map.put("status", 200);
        map.put("message", "修改成功，请重新登录");
        return map;
    }
}

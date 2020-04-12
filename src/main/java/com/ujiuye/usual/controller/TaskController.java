package com.ujiuye.usual.controller;

import com.ujiuye.emp.bean.Employee;
import com.ujiuye.usual.bean.Position;
import com.ujiuye.usual.bean.Task;
import com.ujiuye.usual.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-02 19:27
 **/
@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @RequestMapping(value = "/getAllPosition",method = RequestMethod.GET)
    @ResponseBody
    public List<Position> getAllPosition(){
        List<Position> list =  taskService.getAllPosition();
       return list;
    }
    @RequestMapping("/saveInfo")
    @ResponseBody
    public Map<String,Object> saveInfo(Task task, HttpSession session){
        Employee employee =(Employee)session.getAttribute("loginUser");
        System.out.println(employee);
        task.setEmpFk(employee.getEid());
        System.out.println(task);
        Map<String, Object> map = new HashMap<String, Object>();
        boolean b = taskService.saveInfo(task);
        if(b){
            map.put("message", "添加成功");
        }else{
            map.put("message", "添加失败");
        }
        return map;
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Task> getAll(){
        List<Task> list =   taskService.getAll();
        return list;
    }
    @RequestMapping("/updateStatus")
    @ResponseBody
    public Map<String,Object> updateStatus(Task task){
        Map<String, Object> map = new HashMap<>();
        Task one = getOne(task.getId());
        boolean b = taskService.updateStatus(task);
        if(b&&one.getStatus()!=1){
            map.put("sta", 200);
            map.put("message", "修改成功");
        }else{
            map.put("message", "修改失败");
        }
        return map;
    }
    @RequestMapping("/getOne")
    @ResponseBody
    public Task getOne(Integer id){
        Task task =   taskService.getOne(id);
        return task;
    }

    @RequestMapping("/taskStatus")
    @ResponseBody
    public Integer taskStatus(){
    int count =   taskService.taskStatus();
        return count;
    }
}


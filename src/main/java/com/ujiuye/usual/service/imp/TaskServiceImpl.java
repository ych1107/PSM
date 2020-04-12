package com.ujiuye.usual.service.imp;

import com.ujiuye.emp.bean.Employee;
import com.ujiuye.emp.dao.EmployeeMapper;
import com.ujiuye.usual.bean.Position;
import com.ujiuye.usual.bean.PositionExample;
import com.ujiuye.usual.bean.Task;
import com.ujiuye.usual.bean.TaskExample;
import com.ujiuye.usual.dao.PositionMapper;
import com.ujiuye.usual.dao.TaskMapper;
import com.ujiuye.usual.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-02 19:28
 **/
@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    private PositionMapper positionMapper;
    @Resource
    private TaskMapper taskMapper;
    @Resource
    private EmployeeMapper employeeMapper;
    @Override
    public List<Position> getAllPosition() {
        PositionExample example = new PositionExample();
        List<Position> positions = positionMapper.selectByExample(example);
        return positions;
    }

    @Override
    public boolean saveInfo(Task task) {
        int insert = taskMapper.insert(task);
        if(insert>0) return true;
        else return false;
    }

    @Override
    public List<Task> getAll() {

        TaskExample example = new TaskExample();
        List<Task> tasks = taskMapper.selectByExample(example);
        for (Task task : tasks) {
            Integer empFk = task.getEmpFk2();
            Employee employee = employeeMapper.selectByPrimaryKey(empFk);
            task.setEmployee(employee);
        }
        return tasks;
    }

    @Override
    public boolean updateStatus(Task task) {
        int i = taskMapper.updateByPrimaryKeySelective(task);
        if(i>0) return true;
        else return false;
    }

    @Override
    public Task getOne(Integer id) {
        Task task = taskMapper.selectByPrimaryKey(id);
        Integer empFk = task.getEmpFk();
        Employee employee = employeeMapper.selectByPrimaryKey(empFk);
        task.setEmployee(employee);
        return task;
    }

    @Override
    public int taskStatus() {
        TaskExample example = new TaskExample();
        TaskExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        List<Task> list = taskMapper.selectByExample(example);
        return list.size();
    }

}

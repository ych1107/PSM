package com.ujiuye.emp.service.imp;

import com.ujiuye.emp.bean.Employee;
import com.ujiuye.emp.bean.EmployeeExample;
import com.ujiuye.emp.dao.EmployeeMapper;
import com.ujiuye.emp.service.EmployeeService;
import com.ujiuye.usual.bean.Position;
import com.ujiuye.usual.dao.PositionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-11-27 17:58
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private PositionMapper positionMapper;
    @Override
    public List<Employee> JsonListemp() {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andLFkEqualTo(4);
        List<Employee> employees = employeeMapper.selectByExample(example);
        return employees;
    }

    @Override
    public Employee search(String username) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Employee> employees = employeeMapper.selectByExample(example);
        if(employees.size()>0) return employees.get(0);
        else return null;
    }

    @Override
    public List<Employee> getAll() {
        EmployeeExample example = new EmployeeExample();
        List<Employee> employees = employeeMapper.selectByExample(example);
        for (Employee employee : employees) {
            Integer fk = employee.getpFk();
            Position position = positionMapper.selectByPrimaryKey(fk);
            employee.setPosition(position);
        }
        return employees;
    }

    @Override
    public List<Employee> getOthers(Integer eid) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEidNotEqualTo(eid);
        List<Employee> employees = employeeMapper.selectByExample(example);
        return employees;
    }

    @Override
    public void saveInfo(Employee employee) {
        employee.setdFk(10);
        employee.setlFk(1);
        employeeMapper.insert(employee);
    }

    @Override
    public void changPwd(Employee employee) {

        employeeMapper.updateByPrimaryKeySelective(employee);
    }
}

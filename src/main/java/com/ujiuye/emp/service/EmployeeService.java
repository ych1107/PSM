package com.ujiuye.emp.service;

import com.ujiuye.emp.bean.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> JsonListemp();

    Employee search(String username);

    List<Employee> getAll();

    List<Employee> getOthers(Integer eid);

    void saveInfo(Employee employee);

    void changPwd(Employee employee);
}

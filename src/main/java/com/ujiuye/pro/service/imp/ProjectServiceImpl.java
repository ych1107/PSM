package com.ujiuye.pro.service.imp;

import com.ujiuye.cust.bean.Customer;
import com.ujiuye.cust.dao.CustomerMapper;
import com.ujiuye.emp.bean.Employee;
import com.ujiuye.emp.dao.EmployeeMapper;
import com.ujiuye.pro.bean.Project;
import com.ujiuye.pro.bean.ProjectExample;
import com.ujiuye.pro.dao.ProjectMapper;
import com.ujiuye.pro.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-11-27 16:05
 **/
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private CustomerMapper customerMapper;

    @Autowired
//    private JedisPool jedisPool;
    @Override
    public List<Project> getAll() {
//        Jedis jedis = jedisPool.getResource();
        List<Project> list = null;
//        String projects = jedis.get("customers");
//        if ( projects== null|| projects.equals("")) {
            ProjectExample example = new ProjectExample();
              list = projectMapper.selectByExample(example);
            for (Project project : list) {
                Integer cid = project.getComname();
                Customer customer = customerMapper.selectByPrimaryKey(cid);
                project.setCustomer(customer);
                Integer empFk = project.getEmpFk();
                Employee employee = employeeMapper.selectByPrimaryKey(empFk);
                project.setEmployee(employee);
            }

//            jedis.set("customers", JSON.toJSONString(list));
//        } else {
//            list =  JSON.parseArray(projects,Project.class);
//        }


//        jedis.close();
        return list;
    }

    @Override
    public int saveInfo(Project project) {
        int insert = projectMapper.insert(project);
        return insert;
    }

    @Override
    public boolean batchdel(Integer[] ids) {
        ProjectExample example = new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        criteria.andPidIn(Arrays.asList(ids));
        int i = projectMapper.deleteByExample(example);
        return i==ids.length;
    }

    @Override
    public Project getOne(Integer id) {
        Project project = projectMapper.getOne(id);
        return project;
    }

    @Override
    public boolean edit(Project project) {

        int i = projectMapper.updateByPrimaryKeySelective(project);
        if(i>0)
        return true;
        else return false;
    }

    @Override
    public List<Project> search(Integer cid, String keyword, Integer orderby) {
       List<Project> list =  projectMapper.search(cid,keyword,orderby);
        return list;
    }
}

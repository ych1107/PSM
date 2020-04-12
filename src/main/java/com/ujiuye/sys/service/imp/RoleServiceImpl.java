package com.ujiuye.sys.service.imp;

import com.ujiuye.sys.bean.Role;
import com.ujiuye.sys.bean.RoleExample;
import com.ujiuye.sys.dao.RoleMapper;
import com.ujiuye.sys.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-06 19:52
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int saveInfo(Role role) {
         roleMapper.saveInfo(role);

        return role.getRoleid();
    }

    @Override
    public List<Role> getAll() {
        RoleExample example = new RoleExample();

        return roleMapper.selectByExample(example);
    }
}

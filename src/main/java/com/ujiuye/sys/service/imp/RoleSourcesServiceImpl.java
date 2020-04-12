package com.ujiuye.sys.service.imp;

import com.ujiuye.sys.dao.RoleSourcesMapper;
import com.ujiuye.sys.service.RoleSourcesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-06 20:45
 **/
@Service
public class RoleSourcesServiceImpl implements RoleSourcesService {

    @Resource
    private RoleSourcesMapper roleSourcesMapper;

    @Override
    public void batchInsert(int i, Integer[] ids) {
        roleSourcesMapper.batchInsert(i, ids);
    }
}

package com.ujiuye.datacollect.service.impl;


import com.ujiuye.datacollect.bean.Datacollect;
import com.ujiuye.datacollect.dao.DatacollectMapper;
import com.ujiuye.datacollect.service.DatacollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DatacollectServiceImpl implements DatacollectService {

    @Resource
    private DatacollectMapper datacollectMapper;


    @Override
    public void addOne(Datacollect datacollect) {
        datacollectMapper.insert(datacollect);
    }

    @Override
    public List<Datacollect> getAll() {
        return datacollectMapper.selectByExample(null);

    }
}

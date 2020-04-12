package com.ujiuye.usual.service.imp;

import com.ujiuye.usual.bean.Position;
import com.ujiuye.usual.bean.PositionExample;
import com.ujiuye.usual.dao.PositionMapper;
import com.ujiuye.usual.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-07 15:52
 **/
@Service
public class PositionServiceImpl implements PositionService {

    @Resource
    private PositionMapper positionMapper;

    @Override
    public List<Position> getAll() {
        PositionExample example = new PositionExample();
        return positionMapper.selectByExample(example);
    }

}

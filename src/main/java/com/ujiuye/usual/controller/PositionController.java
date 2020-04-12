package com.ujiuye.usual.controller;

import com.ujiuye.usual.bean.Position;
import com.ujiuye.usual.service.PositionService;
import com.ujiuye.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-07 15:53
 **/
@Controller
@RequestMapping("/posi")
public class PositionController {

    @Autowired
    private PositionService positionService;
    @RequestMapping("/getAll")
    @ResponseBody
    public ResultEntity getAll(){
        List<Position> list = positionService.getAll();
        return ResultEntity.getResultEntity().put("list", list);
    }
}

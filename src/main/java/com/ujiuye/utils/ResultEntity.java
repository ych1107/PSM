package com.ujiuye.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: PSM
 * @description: 异步查询请求工具类
 * @author: Mr.C
 * @create: 2019-12-03 19:13
 **/
public class ResultEntity {

    private Map<String, Object> map = new HashMap<>();

    public static ResultEntity getResultEntity(){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.getMap().put("status", 200);
        resultEntity.getMap().put("message", "操作成功");
        return resultEntity;
    }

    public  ResultEntity put(String key, Object value) {
       this.getMap().put(key, value);
        return this;
    }


    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}

package com.ujiuye.usual.service;

import com.github.pagehelper.PageInfo;
import com.ujiuye.usual.bean.Baoxiao;

import java.util.Map;

public interface BaoxiaoService {
    void saveInfo(Baoxiao baoxiao);

    PageInfo<Baoxiao> getAll(Map<String, Object> map1,String pageNum);

}

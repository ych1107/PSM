package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Functions;

import java.util.List;

public interface FunctionService {
    List<Functions> getAll();

    boolean saveInfo(Functions functions);

    boolean batchdel(Integer[] ids);

    Functions getOne(Integer id);

    boolean edit(Functions functions);

    List<Functions> search(Integer cid, String keyword, Integer orderby);

    List<Functions> getFuncs(Integer id);
}

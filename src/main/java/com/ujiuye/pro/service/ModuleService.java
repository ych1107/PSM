package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Module;

import java.util.List;

public interface ModuleService {
    List<Module> getAll();

    boolean saveInfo(Module module);

    Module getOne(Integer id);

    boolean batchdel(Integer[] ids);

    boolean edit(Module module);

    List<Module> search(Integer cid, String keyword, Integer orderby);

    List<Module> models(Integer cid);
}

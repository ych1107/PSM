package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();

    int saveInfo(Project project);

    boolean batchdel(Integer[] ids);

    Project getOne(Integer id);

    boolean edit(Project project);

    List<Project> search(Integer cid, String keyword, Integer orderby);
}

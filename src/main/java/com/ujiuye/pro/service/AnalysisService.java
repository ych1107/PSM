package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Analysis;
import com.ujiuye.pro.bean.Project;

import java.util.List;

public interface AnalysisService {
    List<Analysis> getAll();

    Analysis getOne(Integer id);

    boolean saveInfo(Analysis analysis);
    List<Project> getPro();

    boolean batchdel(Integer[] ids);

    boolean update(Analysis analysis);

    List<Project> search(Integer cid, String keyword, Integer orderby);


}

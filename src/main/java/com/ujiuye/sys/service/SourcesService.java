package com.ujiuye.sys.service;

import com.ujiuye.sys.bean.Sources;

import java.util.List;

public interface SourcesService {
    List<Sources> getSourceJsoList(int i);

    void saveInfo(Sources sources);

    void delete(Integer id);

    Sources getOne(Integer id);

    void edit(Sources sources);

    List<Sources> getSources(Integer eid);
}

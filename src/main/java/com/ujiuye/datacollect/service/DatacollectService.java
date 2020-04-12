package com.ujiuye.datacollect.service;


import com.ujiuye.datacollect.bean.Datacollect;

import java.util.List;

public interface DatacollectService {
    void addOne(Datacollect datacollect);

    List<Datacollect> getAll();
}

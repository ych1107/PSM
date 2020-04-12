package com.ujiuye.info.service;

import com.github.pagehelper.PageInfo;
import com.ujiuye.info.bean.Email;

import java.util.List;
import java.util.Map;

public interface EmailService {
    void saveInfo(Email email);

    PageInfo<Email> getAll(Map<String, Object> map1, String pageNum);



    boolean batchdel(Integer[] ids);

    List<Email> getEmailAll();
}

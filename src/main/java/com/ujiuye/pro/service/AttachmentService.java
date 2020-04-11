package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Attachment;

import java.util.List;

public interface AttachmentService {
    void saveInfo(Attachment attachment);

    List<Attachment> getAll();

    boolean batchdel(Integer[] ids);

    Attachment getOne(Integer id);

    void edit(Attachment attachment);

    List<Attachment> search(Integer cid, String keyword, Integer orderby);
}

package com.ujiuye.usual.controller;

import com.ujiuye.usual.bean.Notice;
import com.ujiuye.usual.service.NoticeService;
import com.ujiuye.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-05 16:16
 **/
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/saveInfo")
    @ResponseBody
    public ResultEntity saveInfo(Notice notice) {
        notice.setNdate(new Date());
        noticeService.saveInfo(notice);
        return ResultEntity.getResultEntity().put("message", "添加成功");
    }

    @RequestMapping("/getNews")
    @ResponseBody
    public ResultEntity getNews() {

       List<Notice> list =  noticeService.getNews();
        return ResultEntity.getResultEntity().put("list", list);
    }

    @RequestMapping(value = "/getOne",method = RequestMethod.GET)
    @ResponseBody
    public Notice getOne(Integer nid) {
        Notice notice = noticeService.getOne(nid);
        return notice;
    }
}

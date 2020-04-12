package com.ujiuye.usual.service.imp;

import com.ujiuye.usual.bean.Notice;
import com.ujiuye.usual.bean.NoticeExample;
import com.ujiuye.usual.dao.NoticeMapper;
import com.ujiuye.usual.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-05 16:16
 **/
@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;
    @Override
    public void saveInfo(Notice notice) {
        noticeMapper.insert(notice);
    }

    @Override
    public List<Notice> getNews() {
        NoticeExample example = new NoticeExample();
        example.setOrderByClause("ndate desc limit 3");

        List<Notice> notices = noticeMapper.selectByExample(example);


        return notices;
    }

    @Override
    public Notice getOne(Integer nid) {
        Notice notice = noticeMapper.selectByPrimaryKey(nid);
        return notice;
    }
}

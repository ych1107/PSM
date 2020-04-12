package com.ujiuye.usual.service.imp;

import com.ujiuye.usual.bean.Forumpost;
import com.ujiuye.usual.dao.ForumpostMapper;
import com.ujiuye.usual.service.ForumPostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-05 19:30
 **/
@Service
public class ForumPostServiceImpl implements ForumPostService {

    @Resource
    private ForumpostMapper forumpostMapper;
    @Override
    public void saveInfo(Forumpost forumpost) {
        forumpost.setCreatetime(new Date());
        forumpost.setStatus(0);
        forumpostMapper.insert(forumpost);
    }
}

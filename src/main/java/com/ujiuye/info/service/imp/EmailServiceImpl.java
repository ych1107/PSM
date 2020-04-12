package com.ujiuye.info.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.info.bean.Email;
import com.ujiuye.info.bean.EmailExample;
import com.ujiuye.info.dao.EmailMapper;
import com.ujiuye.info.service.EmailService;
import com.ujiuye.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-04 16:44
 **/
@Service
public class
EmailServiceImpl implements EmailService {

    @Resource
    private EmailMapper emailMapper;
    @Override
    public void saveInfo(Email email) {
        emailMapper.insert(email);
    }

    @Override
    public PageInfo<Email> getAll(Map<String, Object> map1, String pageNum) {
        int pageNo = 1;
        if (pageNum!=null){
            try {
                pageNo = Integer.parseInt(pageNum);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        EmailExample example = new EmailExample();
        EmailExample.Criteria criteria = example.createCriteria();
        String s =(String) map1.get("cid");
        String keyword =(String) map1.get("keyword");
        if(keyword!=null){
            criteria.andTitleLike(keyword);
        }
        PageHelper.startPage(pageNo, PageUtils.PAGE_SIZE);
        List<Email> emails = emailMapper.selectByExample(example);
        PageInfo<Email> pageInfo = new PageInfo<Email>(emails,PageUtils.NAVIGATE_PAGES);
        return pageInfo;
    }

    //批量删除邮件
    @Override
    public boolean batchdel(Integer[] ids) {
        EmailExample example = new EmailExample();
        EmailExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        int i = emailMapper.deleteByExample(example);
        System.out.println(i);
        return i==ids.length;

    }

    @Override
    public List<Email> getEmailAll() {

        return emailMapper.getEmailAll();
    }


}

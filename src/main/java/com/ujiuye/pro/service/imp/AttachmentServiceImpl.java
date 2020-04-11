package com.ujiuye.pro.service.imp;

import com.ujiuye.pro.bean.*;
import com.ujiuye.pro.dao.AttachmentMapper;
import com.ujiuye.pro.dao.ProjectMapper;
import com.ujiuye.pro.service.AttachmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-11-29 16:12
 **/
@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Resource
    private AttachmentMapper attachmentMapper;
    @Resource
    private ProjectMapper projectMapper;
    @Override
    public void saveInfo(Attachment attachment) {
        attachmentMapper.insert(attachment);
    }

    @Override
    public List<Attachment> getAll() {
        AttachmentExample example = new AttachmentExample();

        List<Attachment> attachments = attachmentMapper.selectByExample(example);
        for(Attachment attachment:attachments){
            AttachmentExample example1 = new AttachmentExample();
            AttachmentExample.Criteria criteria = example1.createCriteria();
            Integer id = attachment.getProFk();
            criteria.andProFkEqualTo(id);
            int i = attachmentMapper.countByExample(example1);
            Project project = projectMapper.selectByPrimaryKey(id);
            attachment.setProject(project);
            attachment.setCount(i);
        }
        return attachments;
    }

    @Override
    public boolean batchdel(Integer[] ids) {
        AttachmentExample example = new AttachmentExample();
        AttachmentExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        int i = attachmentMapper.deleteByExample(example);
        return i==ids.length;
    }

    @Override
    public Attachment getOne(Integer id) {
        Attachment attachment = attachmentMapper.selectByPrimaryKey(id);
        Integer proFk = attachment.getProFk();
        Project project = projectMapper.selectByPrimaryKey(proFk);
        attachment.setProject(project);
        return attachment;
    }

    @Override
    public void edit(Attachment attachment) {
        System.out.println(attachment);
        attachmentMapper.updateByPrimaryKeySelective(attachment);
    }

    @Override
    public List<Attachment> search(Integer cid, String keyword, Integer orderby) {
        List<Attachment> list = attachmentMapper.search(cid, keyword, orderby);
        for(Attachment attachment:list){
            AttachmentExample example1 = new AttachmentExample();
            AttachmentExample.Criteria criteria = example1.createCriteria();
            Integer id = attachment.getProFk();
            criteria.andProFkEqualTo(id);
            int i = attachmentMapper.countByExample(example1);
            Project project = projectMapper.selectByPrimaryKey(id);
            attachment.setProject(project);
            attachment.setCount(i);
        }
        return list;
    }
}

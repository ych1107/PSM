package com.ujiuye.emp.service.imp;

import com.ujiuye.emp.bean.Archives;
import com.ujiuye.emp.bean.ArchivesExample;
import com.ujiuye.emp.dao.ArchivesMapper;
import com.ujiuye.emp.service.ArchivesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-04 16:47
 **/
@Service
public class ArchivesServiceImpl implements ArchivesService {

    @Resource
    private ArchivesMapper archivesMapper;
    @Override
    public String getEmailByEid(Integer eid) {
        ArchivesExample example = new ArchivesExample();
        ArchivesExample.Criteria criteria = example.createCriteria();
        criteria.andEmpFkEqualTo(eid);
        List<Archives> archives = archivesMapper.selectByExample(example);
        if (archives != null) {
            return archives.get(0).getEmail();
        }
        return null;
    }
}

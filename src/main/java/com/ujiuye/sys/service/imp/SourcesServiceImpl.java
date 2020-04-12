package com.ujiuye.sys.service.imp;

import com.ujiuye.sys.bean.Sources;
import com.ujiuye.sys.bean.SourcesExample;
import com.ujiuye.sys.dao.SourcesMapper;
import com.ujiuye.sys.service.SourcesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-06 11:27
 **/
@Service
public class SourcesServiceImpl implements SourcesService {

    @Resource
    private SourcesMapper sourcesMapper;

    @Override
    public List<Sources> getSourceJsoList(int i) {
        SourcesExample example = new SourcesExample();
        SourcesExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(i);
        List<Sources> sources = sourcesMapper.selectByExample(example);
        return sources;
    }

    @Override
    public void saveInfo(Sources sources) {
        sourcesMapper.insert(sources);
    }

    @Override
    public void delete(Integer id) {


        sourcesMapper.deleteByPrimaryKey(id);

    }

    @Override
    public Sources getOne(Integer id) {
        return sourcesMapper.selectByPrimaryKey(id);
    }

    @Override
    public void edit(Sources sources) {
        sourcesMapper.updateByPrimaryKeySelective(sources);
    }

    @Override
    public List<Sources> getSources(Integer eid) {
        List<Sources>  sources = sourcesMapper.getSources(eid,1);
        for (Sources source : sources) {
            List<Sources> sources1 = sourcesMapper.getSources(eid, source.getId());
            source.setChildren(sources1);
        }
        return sources;
    }
}

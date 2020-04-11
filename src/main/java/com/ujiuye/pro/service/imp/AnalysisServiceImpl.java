package com.ujiuye.pro.service.imp;

import com.ujiuye.pro.bean.Analysis;
import com.ujiuye.pro.bean.AnalysisExample;
import com.ujiuye.pro.bean.Project;
import com.ujiuye.pro.bean.ProjectExample;
import com.ujiuye.pro.dao.AnalysisMapper;
import com.ujiuye.pro.dao.ProjectMapper;
import com.ujiuye.pro.service.AnalysisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-11-28 19:02
 **/
@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Resource
    private AnalysisMapper analysisMapper;
    @Resource
    private ProjectMapper projectMapper;

    @Override
    public Analysis getOne(Integer id) {
        Analysis analysis = analysisMapper.selectByPrimaryKey(id);

        return analysis;
    }

    @Override
    public List<Analysis> getAll() {
        AnalysisExample example = new AnalysisExample();
        List<Analysis> list = analysisMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<Project> getPro() {
        List<Analysis> all = getAll();
        System.out.println(all);
        List<Integer> list = new ArrayList<>();
        for(Analysis analysis:all){
            Integer id = analysis.getId();
            list.add(id);
        }
        ProjectExample example = new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        criteria.andPidNotIn(list);
        List<Project> projects = projectMapper.selectByExample(example);
        return projects;
    }


    @Override
    public boolean saveInfo(Analysis analysis) {
        analysis.setAddtime(new Date());
        int insert = analysisMapper.insert(analysis);
        if(insert>0) return true;
        else return false;
    }


    @Override
    public boolean batchdel(Integer[] ids) {
        AnalysisExample example = new AnalysisExample();
        AnalysisExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        int i = analysisMapper.deleteByExample(example);
        return i==ids.length;
    }

    @Override
    public boolean update(Analysis analysis) {
        analysis.setUpdatetime(new Date());
        int i = analysisMapper.updateByPrimaryKeySelective(analysis);
        if(i>0)return true;
        else return false;

    }

    @Override
    public List<Project> search(Integer cid, String keyword, Integer orderby) {
        List<Project> list = analysisMapper.search(cid, keyword, orderby);
        return list;
    }

}

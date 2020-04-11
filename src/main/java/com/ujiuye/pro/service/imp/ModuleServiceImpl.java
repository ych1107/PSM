package com.ujiuye.pro.service.imp;

import com.ujiuye.pro.bean.Analysis;
import com.ujiuye.pro.bean.Module;
import com.ujiuye.pro.bean.ModuleExample;
import com.ujiuye.pro.dao.AnalysisMapper;
import com.ujiuye.pro.dao.ModuleMapper;
import com.ujiuye.pro.dao.ProjectMapper;
import com.ujiuye.pro.service.ModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-11-30 14:18
 **/
@Service
public class ModuleServiceImpl implements ModuleService {


    @Resource
    private ModuleMapper moduleMapper;
    @Resource
    private AnalysisMapper analysisMapper;
    @Resource
    private ProjectMapper projectMapper;
    @Override
    public List<Module> getAll() {
        ModuleExample example = new ModuleExample();
        List<Module> list = moduleMapper.selectByExample(example);
        for (int i = 0; i <list.size() ; i++) {
            Module module = list.get(i);
            Integer aid = module.getAnalysisFk();
            Analysis analysis = analysisMapper.selectByPrimaryKey(aid);
            module.setAnalysis(analysis);
        }
        return list;
    }

    @Override
    public boolean saveInfo(Module module) {
        int i = moduleMapper.insert(module);
        if (i>0) return true;
        else return false;
    }

    @Override
    public Module getOne(Integer id) {
        Module module = moduleMapper.selectByPrimaryKey(id);
        Integer aid = module.getAnalysisFk();
        Analysis analysis = analysisMapper.selectByPrimaryKey(aid);
        module.setAnalysis(analysis);
        return module;
    }

    @Override
    public boolean batchdel(Integer[] ids) {
        ModuleExample example = new ModuleExample();
        ModuleExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        int i = moduleMapper.deleteByExample(example);
        return i==ids.length;
    }

    @Override
    public boolean edit(Module module) {
        int i = moduleMapper.updateByPrimaryKeySelective(module);
        if (i>0) return true;
        else return false;
    }

    @Override
    public List<Module> search(Integer cid, String keyword, Integer orderby) {
        List<Module> list = moduleMapper.search(cid, keyword, orderby);
        for(Module module:list){
            Integer analysisFk = module.getAnalysisFk();
            Analysis analysis = analysisMapper.selectByPrimaryKey(analysisFk);
            module.setAnalysis(analysis);
        }
        return list;
    }

    @Override
    public List<Module> models(Integer cid) {
        ModuleExample example = new ModuleExample();
        ModuleExample.Criteria criteria = example.createCriteria();
        criteria.andAnalysisFkEqualTo(cid);
        List<Module> modules = moduleMapper.selectByExample(example);
        return modules;

    }
}

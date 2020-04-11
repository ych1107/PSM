package com.ujiuye.pro.service.imp;

import com.ujiuye.pro.bean.*;
import com.ujiuye.pro.dao.AnalysisMapper;
import com.ujiuye.pro.dao.FunctionsMapper;
import com.ujiuye.pro.dao.ModuleMapper;
import com.ujiuye.pro.service.FunctionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-11-30 18:39
 **/
@Service
public class FunctionServiceImpl implements FunctionService {
    ModuleServiceImpl moduleService = new ModuleServiceImpl();
    @Resource
    private FunctionsMapper functionsMapper;
    @Resource
    private ModuleMapper moduleMapper;
    @Resource
    private AnalysisMapper analysisMapper;
    @Override
    public List<Functions> getAll() {
        FunctionsExample example = new FunctionsExample();
        List<Functions> list = functionsMapper.selectByExample(example);
        for(Functions functions:list){
            Integer mid = functions.getModeleFk();
            Module module = moduleMapper.selectByPrimaryKey(mid);
            Integer aid = module.getAnalysisFk();
            Analysis analysis = analysisMapper.selectByPrimaryKey(aid);
            module.setAnalysis(analysis);
            functions.setModule(module);
        }
        return list;
    }

    @Override
    public boolean saveInfo(Functions functions) {
        int i = functionsMapper.insert(functions);
        if (i>0) return true;
        else return false;
    }

    @Override
    public boolean batchdel(Integer[] ids) {
        FunctionsExample example = new FunctionsExample();
        FunctionsExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        int i = functionsMapper.deleteByExample(example);
        return i==ids.length;
    }

    @Override
    public Functions getOne(Integer id) {
        FunctionsExample example = new FunctionsExample();
        Functions functions = functionsMapper.selectByPrimaryKey(id);
        Integer mid = functions.getModeleFk();
        Module module = moduleMapper.selectByPrimaryKey(mid);
        Integer aid = module.getAnalysisFk();
        Analysis analysis = analysisMapper.selectByPrimaryKey(aid);
        module.setAnalysis(analysis);
        functions.setModule(module);
        return functions;
    }
    @Override
    public boolean edit(Functions functions) {
        int i = functionsMapper.updateByPrimaryKeySelective(functions);
        if (i>0) return true;
        else return false;
    }
    @Override
    public List<Functions> search(Integer cid, String keyword, Integer orderby) {
        List<Functions> list = functionsMapper.search(cid, keyword, orderby);
        for(Functions functions:list){
            Integer mid = functions.getModeleFk();
            Module module = moduleMapper.selectByPrimaryKey(mid);
            Integer aid = module.getAnalysisFk();
            Analysis analysis = analysisMapper.selectByPrimaryKey(aid);
            module.setAnalysis(analysis);
            functions.setModule(module);
        }
        return list;
    }

    @Override
    public List<Functions> getFuncs(Integer id) {
        FunctionsExample example = new FunctionsExample();
        FunctionsExample.Criteria criteria = example.createCriteria();
        criteria.andModeleFkEqualTo(id);
        List<Functions> functions = functionsMapper.selectByExample(example);
        return functions;
    }
}

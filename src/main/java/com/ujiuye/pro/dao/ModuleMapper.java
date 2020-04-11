package com.ujiuye.pro.dao;

import com.ujiuye.pro.bean.Module;
import com.ujiuye.pro.bean.ModuleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleMapper {
    int countByExample(ModuleExample example);

    int deleteByExample(ModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Module record);

    int insertSelective(Module record);

    List<Module> selectByExample(ModuleExample example);

    Module selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByExample(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    List<Module> search(@Param("cid") Integer cid,@Param("keyword") String keyword, @Param("orderby")Integer orderby);
}
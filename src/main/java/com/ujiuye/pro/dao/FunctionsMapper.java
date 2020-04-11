package com.ujiuye.pro.dao;

import com.ujiuye.pro.bean.Functions;
import com.ujiuye.pro.bean.FunctionsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FunctionsMapper {
    int countByExample(FunctionsExample example);

    int deleteByExample(FunctionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Functions record);

    int insertSelective(Functions record);

    List<Functions> selectByExample(FunctionsExample example);

    Functions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Functions record, @Param("example") FunctionsExample example);

    int updateByExample(@Param("record") Functions record, @Param("example") FunctionsExample example);

    int updateByPrimaryKeySelective(Functions record);

    int updateByPrimaryKey(Functions record);

    List<Functions> search(@Param("cid") Integer cid,@Param("keyword") String keyword, @Param("orderby")Integer orderby);
}
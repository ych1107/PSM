package com.ujiuye.sys.dao;

import com.ujiuye.sys.bean.RoleSourcesExample;
import com.ujiuye.sys.bean.RoleSourcesKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleSourcesMapper {
    int countByExample(RoleSourcesExample example);

    int deleteByExample(RoleSourcesExample example);

    int deleteByPrimaryKey(RoleSourcesKey key);

    int insert(RoleSourcesKey record);

    int insertSelective(RoleSourcesKey record);

    List<RoleSourcesKey> selectByExample(RoleSourcesExample example);

    int updateByExampleSelective(@Param("record") RoleSourcesKey record, @Param("example") RoleSourcesExample example);

    int updateByExample(@Param("record") RoleSourcesKey record, @Param("example") RoleSourcesExample example);

    void batchInsert(@Param("id") int i, @Param("ids") Integer[] ids);
}
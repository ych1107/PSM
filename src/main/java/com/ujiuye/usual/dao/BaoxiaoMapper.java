package com.ujiuye.usual.dao;

import com.ujiuye.usual.bean.Baoxiao;
import com.ujiuye.usual.bean.BaoxiaoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaoxiaoMapper {
    int countByExample(BaoxiaoExample example);

    int deleteByExample(BaoxiaoExample example);

    int deleteByPrimaryKey(String bxid);

    int insert(Baoxiao record);

    int insertSelective(Baoxiao record);

    List<Baoxiao> selectByExample(BaoxiaoExample example);

    Baoxiao selectByPrimaryKey(String bxid);

    int updateByExampleSelective(@Param("record") Baoxiao record, @Param("example") BaoxiaoExample example);

    int updateByExample(@Param("record") Baoxiao record, @Param("example") BaoxiaoExample example);

    int updateByPrimaryKeySelective(Baoxiao record);

    int updateByPrimaryKey(Baoxiao record);
}
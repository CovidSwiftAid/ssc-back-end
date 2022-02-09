package com.shu.ssc.mapper;


import com.shu.ssc.entity.covid.RealTimeWeiboFinal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RealTimeWeiboFinalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RealTimeWeiboFinal record);

    int insertSelective(RealTimeWeiboFinal record);

    RealTimeWeiboFinal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RealTimeWeiboFinal record);

    int updateByPrimaryKeyWithBLOBs(RealTimeWeiboFinal record);

    int updateByPrimaryKey(RealTimeWeiboFinal record);
}
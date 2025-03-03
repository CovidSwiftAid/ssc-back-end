package com.shu.ssc.mapper;


import com.shu.ssc.entity.covid.RealTimeWeiboAfterProcessing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RealTimeWeiboAfterProcessingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RealTimeWeiboAfterProcessing record);

    int insertSelective(RealTimeWeiboAfterProcessing record);

    RealTimeWeiboAfterProcessing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RealTimeWeiboAfterProcessing record);

    int updateByPrimaryKey(RealTimeWeiboAfterProcessing record);

    RealTimeWeiboAfterProcessing getWeiboByLocationName(String locationName);

    List<RealTimeWeiboAfterProcessing> getAllRealTimeWeiboAfterProcessing();

    List<RealTimeWeiboAfterProcessing> getAllRealTimeWeiboAfterProcessingWithoutText();
}
package com.shu.ssc.mapper;


import com.shu.ssc.entity.covid.RealTimeWeibo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RealTimeWeiboMapper {
    int deleteByPrimaryKey(String id);

    int insert(RealTimeWeibo record);

    int insertSelective(RealTimeWeibo record);

    RealTimeWeibo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RealTimeWeibo record);

    int updateByPrimaryKey(RealTimeWeibo record);

    List<RealTimeWeibo> getSameDayWeibosByID(String wbID);
}
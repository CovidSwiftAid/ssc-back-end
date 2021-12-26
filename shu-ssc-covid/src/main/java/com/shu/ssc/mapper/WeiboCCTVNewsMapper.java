package com.shu.ssc.mapper;


import com.shu.ssc.entity.covid.WeiboCCTVNews;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WeiboCCTVNewsMapper {
    int deleteByPrimaryKey(String id);

    int insert(WeiboCCTVNews record);

    int insertSelective(WeiboCCTVNews record);

    WeiboCCTVNews selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WeiboCCTVNews record);

    int updateByPrimaryKeyWithBLOBs(WeiboCCTVNews record);

    int updateByPrimaryKey(WeiboCCTVNews record);

    List<WeiboCCTVNews> getAllWeiboCCTVNews();
}
package com.shu.ssc.mapper;

import com.shu.ssc.entity.Live;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LiveMapper {
    int deleteByPrimaryKey(Integer liveId);

    int insert(Live record);

    int insertSelective(Live record);

    Live selectByPrimaryKey(Integer liveId);

    int updateByPrimaryKeySelective(Live record);

    int updateByPrimaryKeyWithBLOBs(Live record);

    int updateByPrimaryKey(Live record);
}
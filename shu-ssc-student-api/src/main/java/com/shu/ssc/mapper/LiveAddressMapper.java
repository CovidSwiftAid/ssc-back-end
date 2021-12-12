package com.shu.ssc.mapper;

import com.shu.ssc.entity.LiveAddress;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LiveAddressMapper {
    int deleteByPrimaryKey(Integer liveAddressId);

    int insert(LiveAddress record);

    int insertSelective(LiveAddress record);

    LiveAddress selectByPrimaryKey(Integer liveAddressId);

    int updateByPrimaryKeySelective(LiveAddress record);

    int updateByPrimaryKey(LiveAddress record);
}
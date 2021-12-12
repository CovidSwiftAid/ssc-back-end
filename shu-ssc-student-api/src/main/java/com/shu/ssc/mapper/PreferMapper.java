package com.shu.ssc.mapper;

import com.shu.ssc.entity.Prefer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PreferMapper {
    int deleteByPrimaryKey(Integer preferId);

    int insert(Prefer record);

    int insertSelective(Prefer record);

    Prefer selectByPrimaryKey(Integer preferId);

    int updateByPrimaryKeySelective(Prefer record);

    int updateByPrimaryKey(Prefer record);
}
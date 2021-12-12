package com.shu.ssc.mapper;

import com.shu.ssc.entity.Major;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MajorMapper {
    int deleteByPrimaryKey(Integer majorId);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Integer majorId);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}
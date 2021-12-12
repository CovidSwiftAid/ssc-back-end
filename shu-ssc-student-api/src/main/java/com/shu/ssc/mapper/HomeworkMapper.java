package com.shu.ssc.mapper;

import com.shu.ssc.entity.Homework;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeworkMapper {
    int deleteByPrimaryKey(Integer homeworkId);

    int insert(Homework record);

    int insertSelective(Homework record);

    Homework selectByPrimaryKey(Integer homeworkId);

    int updateByPrimaryKeySelective(Homework record);

    int updateByPrimaryKeyWithBLOBs(Homework record);

    int updateByPrimaryKey(Homework record);
}
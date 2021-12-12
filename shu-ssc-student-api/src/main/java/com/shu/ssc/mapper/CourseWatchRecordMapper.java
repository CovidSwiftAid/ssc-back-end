package com.shu.ssc.mapper;

import com.shu.ssc.entity.CourseWatchRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseWatchRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseWatchRecord record);

    int insertSelective(CourseWatchRecord record);

    CourseWatchRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseWatchRecord record);

    int updateByPrimaryKey(CourseWatchRecord record);
}
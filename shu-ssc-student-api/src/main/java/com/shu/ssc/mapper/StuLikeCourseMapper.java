package com.shu.ssc.mapper;

import com.shu.ssc.entity.StuLikeCourse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuLikeCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StuLikeCourse record);

    int insertSelective(StuLikeCourse record);

    StuLikeCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuLikeCourse record);

    int updateByPrimaryKey(StuLikeCourse record);
}
package com.shu.ssc.mapper;

import com.shu.ssc.entity.CourseComment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseCommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(CourseComment record);

    int insertSelective(CourseComment record);

    CourseComment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(CourseComment record);

    int updateByPrimaryKey(CourseComment record);
}
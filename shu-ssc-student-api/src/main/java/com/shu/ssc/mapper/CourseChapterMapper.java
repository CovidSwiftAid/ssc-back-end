package com.shu.ssc.mapper;

import com.shu.ssc.entity.CourseChapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CourseChapterMapper {
    int deleteByPrimaryKey(@Param("courseId") Integer courseId, @Param("chapterId") Integer chapterId);

    int insert(CourseChapter record);

    int insertSelective(CourseChapter record);

    CourseChapter selectByPrimaryKey(@Param("courseId") Integer courseId, @Param("chapterId") Integer chapterId);

    int updateByPrimaryKeySelective(CourseChapter record);

    int updateByPrimaryKey(CourseChapter record);
}
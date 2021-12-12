package com.shu.ssc.mapper;

import com.shu.ssc.entity.CourseChapterVideo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CourseChapterVideoMapper {
    int deleteByPrimaryKey(@Param("chapterId") Integer chapterId, @Param("courseId") Integer courseId, @Param("videoId") Integer videoId);

    int insert(CourseChapterVideo record);

    int insertSelective(CourseChapterVideo record);

    CourseChapterVideo selectByPrimaryKey(@Param("chapterId") Integer chapterId, @Param("courseId") Integer courseId, @Param("videoId") Integer videoId);

    int updateByPrimaryKeySelective(CourseChapterVideo record);

    int updateByPrimaryKey(CourseChapterVideo record);
}
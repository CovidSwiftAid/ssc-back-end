package com.shu.ssc.mapper;

import com.shu.ssc.entity.CommentAnalysisResult;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentAnalysisResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentAnalysisResult record);

    int insertSelective(CommentAnalysisResult record);

    CommentAnalysisResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentAnalysisResult record);

    int updateByPrimaryKeyWithBLOBs(CommentAnalysisResult record);

    int updateByPrimaryKey(CommentAnalysisResult record);
}
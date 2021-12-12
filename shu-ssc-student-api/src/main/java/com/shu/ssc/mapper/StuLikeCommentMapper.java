package com.shu.ssc.mapper;

import com.shu.ssc.entity.StuLikeComment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuLikeCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StuLikeComment record);

    int insertSelective(StuLikeComment record);

    StuLikeComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuLikeComment record);

    int updateByPrimaryKey(StuLikeComment record);
}
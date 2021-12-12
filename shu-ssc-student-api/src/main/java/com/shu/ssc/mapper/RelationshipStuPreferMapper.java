package com.shu.ssc.mapper;

import com.shu.ssc.entity.RelationshipStuPrefer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RelationshipStuPreferMapper {
    int deleteByPrimaryKey(@Param("studentId") Integer studentId, @Param("preferId") Integer preferId);

    int insert(RelationshipStuPrefer record);

    int insertSelective(RelationshipStuPrefer record);
}
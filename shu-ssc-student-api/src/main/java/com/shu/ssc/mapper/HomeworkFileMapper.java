package com.shu.ssc.mapper;

import com.shu.ssc.entity.HomeworkFile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeworkFileMapper {
    int deleteByPrimaryKey(Integer homeworkFileId);

    int insert(HomeworkFile record);

    int insertSelective(HomeworkFile record);

    HomeworkFile selectByPrimaryKey(Integer homeworkFileId);

    int updateByPrimaryKeySelective(HomeworkFile record);

    int updateByPrimaryKey(HomeworkFile record);
}
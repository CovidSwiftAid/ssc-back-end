package com.shu.ssc.mapper;

import com.shu.ssc.entity.TaskFile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskFileMapper {
    int deleteByPrimaryKey(Integer taskFileId);

    int insert(TaskFile record);

    int insertSelective(TaskFile record);

    TaskFile selectByPrimaryKey(Integer taskFileId);

    int updateByPrimaryKeySelective(TaskFile record);

    int updateByPrimaryKey(TaskFile record);
}
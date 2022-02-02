package com.shu.ssc.mapper;

import com.shu.ssc.entity.covid.Tips;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author oxotn3
 * @create 2022-01-02
 * @description
 */
@Mapper
public interface TipsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tips record);

    int insertSelective(Tips record);

    Tips selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tips record);

    int updateByPrimaryKeyWithBLOBs(Tips record);

    int updateByPrimaryKey(Tips record);
}
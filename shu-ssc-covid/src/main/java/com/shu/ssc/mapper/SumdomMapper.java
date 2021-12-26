package com.shu.ssc.mapper;


import com.shu.ssc.entity.covid.Sumdom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SumdomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sumdom record);

    int insertSelective(Sumdom record);

    Sumdom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sumdom record);

    int updateByPrimaryKey(Sumdom record);

    List<Sumdom> getAllSumdom();
}
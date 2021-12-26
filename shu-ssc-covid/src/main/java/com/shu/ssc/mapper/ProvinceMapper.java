package com.shu.ssc.mapper;

import com.shu.ssc.entity.covid.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ProvinceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);

    List<Province> getAllProvince();
}
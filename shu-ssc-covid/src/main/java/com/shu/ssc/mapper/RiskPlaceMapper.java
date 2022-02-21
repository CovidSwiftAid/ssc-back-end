package com.shu.ssc.mapper;


import com.shu.ssc.entity.covid.RiskPlace;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RiskPlaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RiskPlace record);

    int insertSelective(RiskPlace record);

    RiskPlace selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RiskPlace record);

    int updateByPrimaryKey(RiskPlace record);

    List<RiskPlace> getHighRiskPlace();

    List<RiskPlace> getMediumRiskPlace();
}
package com.shu.ssc.service.impl;

import com.shu.ssc.entity.covid.RiskPlace;
import com.shu.ssc.mapper.RiskPlaceMapper;
import com.shu.ssc.service.RiskPlaceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oxotn3
 * @create 2022-02-21
 * @description
 */
@Service
public class RiskPlaceServiceImpl implements RiskPlaceService {
    @Resource
    RiskPlaceMapper mapper;

    @Override
    public List<RiskPlace> getHighRiskPlace() {
        return mapper.getHighRiskPlace();
    }

    @Override
    public List<RiskPlace> getMediumRiskPlace() {
        return mapper.getMediumRiskPlace();
    }
}

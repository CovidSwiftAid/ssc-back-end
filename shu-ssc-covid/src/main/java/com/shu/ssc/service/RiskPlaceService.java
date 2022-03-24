package com.shu.ssc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shu.ssc.common.dto.RiskPlaceDto;
import com.shu.ssc.entity.covid.RiskPlace;

import java.util.List;

/**
 * @author oxotn3
 * @create 2022-02-21
 * @description
 */
public interface RiskPlaceService {
    List<RiskPlace> getHighRiskPlace() throws JsonProcessingException;

    List<RiskPlace> getMediumRiskPlace() throws JsonProcessingException;
}

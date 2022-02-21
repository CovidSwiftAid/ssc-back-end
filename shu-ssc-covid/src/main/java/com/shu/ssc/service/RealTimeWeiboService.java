package com.shu.ssc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shu.ssc.dto.ReverseGeocodingDto;
import com.shu.ssc.dto.SuspectedResultDto;
import com.shu.ssc.entity.covid.MapResponseEntity;
import com.shu.ssc.entity.covid.RealTimeWeiboAfterProcessing;
import com.shu.ssc.entity.covid.RealTimeWeiboFinal;

import java.util.List;

/**
 * @author oxotn3
 * @create 2022-02-09
 * @description
 */
public interface RealTimeWeiboService {
    List<String> getAllSuspectedLocations();

    List<MapResponseEntity> getAllSuspectedLocationsInCoordinates() throws JsonProcessingException;

    void saveAllSuspectedLocations() throws JsonProcessingException;

    SuspectedResultDto getSuspectedResult(String locationName);

    ReverseGeocodingDto.Result getReverseGeocoding(Double lat, Double lng) throws JsonProcessingException;

}

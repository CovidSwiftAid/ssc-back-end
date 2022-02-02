package com.shu.ssc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shu.ssc.dto.MapResponseDto;
import com.shu.ssc.entity.covid.MapResponseEntity;

import java.util.List;

/**
 * @author oxotn3
 * @create 2022-01-19
 * @description
 */
public interface TracksService {
    List<String> getAllTracks();

    List<MapResponseEntity> getAllTracksInCoordinates() throws JsonProcessingException;
}

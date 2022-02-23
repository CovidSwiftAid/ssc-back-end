package com.shu.ssc.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shu.ssc.common.dto.RiskPlaceDto;
import com.shu.ssc.dto.MapResponseDto;
import com.shu.ssc.entity.covid.MapResponseEntity;
import com.shu.ssc.entity.covid.RiskPlace;
import com.shu.ssc.mapper.RiskPlaceMapper;
import com.shu.ssc.service.RiskPlaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oxotn3
 * @create 2022-02-21
 * @description
 */
@Service
public class RiskPlaceServiceImpl implements RiskPlaceService {
    public static final String ak = "3uRTECEK0CChcOWsegpKVoDoPcVtV5Tk";

    @Resource
    RiskPlaceMapper mapper;

    @Resource
    RestTemplate restTemplate;

    @Override
    public List<RiskPlaceDto> getHighRiskPlace() throws JsonProcessingException {

        List<RiskPlaceDto> res = new ArrayList<>();
        List<RiskPlace> riskPlaceList = mapper.getHighRiskPlace();

        for (RiskPlace place : riskPlaceList) {
            RiskPlaceDto dto = new RiskPlaceDto();
            // https://api.map.baidu.com/geocoding/v3/?address=ADDRESS&output=json&ak=您的ak&callback=showLocation
            String url = "https://api.map.baidu.com/geocoding/v3/?address=" + place.getAreaName() + "&output=json&ak=" + ak;
            ResponseEntity<String> re = restTemplate.getForEntity(url, String.class);
//            System.out.println("====== etForEntity(getUrl, String.class" + re.getBody());
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//忽略未知字段
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);// 忽略字段大小写
            MapResponseDto response = mapper.readValue(re.getBody(), MapResponseDto.class);
            dto.setMapResponseDto(response);
            dto.setRiskPlace(place);
            res.add(dto);
        }
        return res;
    }

    @Override
    public List<RiskPlaceDto> getMediumRiskPlace() throws JsonProcessingException {
        List<RiskPlaceDto> res = new ArrayList<>();
        List<RiskPlace> riskPlaceList = mapper.getMediumRiskPlace();

        for (RiskPlace place : riskPlaceList) {
            RiskPlaceDto dto = new RiskPlaceDto();
            // https://api.map.baidu.com/geocoding/v3/?address=ADDRESS&output=json&ak=您的ak&callback=showLocation
            String url = "https://api.map.baidu.com/geocoding/v3/?address=" + place.getAreaName() + "&output=json&ak=" + ak;
            ResponseEntity<String> re = restTemplate.getForEntity(url, String.class);
//            System.out.println("====== etForEntity(getUrl, String.class" + re.getBody());
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//忽略未知字段
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);// 忽略字段大小写
            MapResponseDto response = mapper.readValue(re.getBody(), MapResponseDto.class);
            dto.setMapResponseDto(response);
            dto.setRiskPlace(place);
            res.add(dto);
        }
        return res;
    }
}

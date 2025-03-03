package com.shu.ssc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.util.StringUtils;
import com.shu.ssc.dto.MapResponseDto;
import com.shu.ssc.dto.ReverseGeocodingDto;
import com.shu.ssc.dto.SimpleWeiboDto;
import com.shu.ssc.dto.SuspectedResultDto;
import com.shu.ssc.entity.covid.EightBlogs;
import com.shu.ssc.entity.covid.MapResponseEntity;
import com.shu.ssc.entity.covid.RealTimeWeibo;
import com.shu.ssc.entity.covid.RealTimeWeiboAfterProcessing;
import com.shu.ssc.mapper.EightBlogsMapper;
import com.shu.ssc.mapper.RealTimeWeiboAfterProcessingMapper;
import com.shu.ssc.mapper.RealTimeWeiboFinalMapper;
import com.shu.ssc.mapper.RealTimeWeiboMapper;
import com.shu.ssc.service.RealTimeWeiboService;
import com.shu.ssc.service.TracksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oxotn3
 * @create 2022-02-09
 * @description
 */
@Slf4j
@Service
public class RealTimeWeiboServiceImpl implements RealTimeWeiboService {
    public static final String ak = "3uRTECEK0CChcOWsegpKVoDoPcVtV5Tk";

    @Resource
    RestTemplate restTemplate;

    @Resource
    RealTimeWeiboAfterProcessingMapper afterProcessingMapper;

    @Resource
    TracksService tracksService;

    @Resource
    RealTimeWeiboFinalMapper finalMapper;

    @Resource
    RealTimeWeiboMapper realTimeWeiboMapper;

    @Resource
    EightBlogsMapper eightBlogsMapper;

    @Override
    public List<String> getAllSuspectedLocations() {
        List<RealTimeWeiboAfterProcessing> trackList = afterProcessingMapper.getAllRealTimeWeiboAfterProcessing();
//
//        List<String> res = new ArrayList<>();
//        for (RealTimeWeiboAfterProcessing t : trackList) {
//            String track = t.getText();
//            Set<String> locations = new ConcurrentHashSet<>();
//            String[] locs = track.substring(1, track.length() - 1).split(",");
//            String city = null;
//            for (String l : locs) {
//                String after = l.replaceAll("\'", "").trim();
//                // 记录市名
//                if (after.charAt(after.length() - 1) == '市') {
//                    if (city == null) city = after;
//                    continue;
//                }
//                // 排除一些不正确的/太模糊的
//                if (after.length() < 3 || after.contains("#") || after.contains("病例") || after.contains("阳性") || after.contains("报告") || after.contains("疫情")) continue;
//                if (locations.isEmpty()) {
//                    locations.add(after);
//                    continue;
//                }
//                boolean add = true;
//                for (String exist : locations) {
//                    if (exist.contains(after)) {
//                        if (exist.length() >= after.length()) {
//                            // 已经有更详细的，不加
//                            add = false;
//                            break;
//                        } else {
//                            // 当前更详细，更新
//                            locations.remove(exist);
//                            locations.add(after);
//                            break;
//                        }
//                    } else {
//                        continue;
//                    }
//                }
//                if (add) {
//                    locations.add(after);
//                }
//            }
//            for (String l : locations) {
//                if (city != null && !l.contains(city)) {
//                    // 加上市名
//                    l = city + l;
//                }
//                res.add(l);
////                System.out.print(l + ", ");
//            }
//        }

//        // 再排除掉已有的
//        // 时间复杂度很高，缓存起来比较好
//        // TODO:放到redis里
//        List<String> finalRes = new ArrayList<>();
//        List<String> already = tracksService.getAllTracks();
//        for (String item : res) {
//            boolean exist = false;
//            for (String al : already) {
//                if (al.contains(item)) {
////                    res.remove(item);
//                    exist = true;
//                    break;
//                }
//            }
//            if (!exist) {
//                finalRes.add(item);
//            }
//        }

//        return finalRes;
        List<String> res = new ArrayList<>();
        List<String> finalRes = new ArrayList<>();
        for (RealTimeWeiboAfterProcessing wb : trackList) {
            res.add(wb.getPlace());
        }
        return res;
    }



    @Override
    public List<RealTimeWeiboAfterProcessing> getAllSuspectedLocationsInCoordinates() throws JsonProcessingException {
//        List<MapResponseEntity> res = new ArrayList<>();
        List<RealTimeWeiboAfterProcessing> trackList = afterProcessingMapper.getAllRealTimeWeiboAfterProcessingWithoutText();


//        for (String track : tracks) {
//            // https://api.map.baidu.com/geocoding/v3/?address=ADDRESS&output=json&ak=您的ak&callback=showLocation
//            String url = "https://api.map.baidu.com/geocoding/v3/?address=" + track + "&output=json&ak=" + ak;
//            ResponseEntity<String> re = restTemplate.getForEntity(url, String.class);
////            System.out.println("====== etForEntity(getUrl, String.class" + re.getBody());
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//忽略未知字段
//            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);// 忽略字段大小写
//            MapResponseDto response = mapper.readValue(re.getBody(), MapResponseDto.class);
//            MapResponseEntity entity = new MapResponseEntity(response);
//            entity.setLocationName(track);
//            res.add(entity);
//        }

        return trackList;
    }


    @Override
    public void saveAllSuspectedLocations() throws JsonProcessingException {
//        List<MapResponseEntity> res = getAllSuspectedLocationsInCoordinates();
//        List<String> valid = new ArrayList<>();
//        for (MapResponseEntity item : res) {
////            System.out.println(item.locationName + ",  " + item.mapResponseDto.getStatus());
//            if (item.mapResponseDto.getStatus() == 0) {
//                // 找到，说明没有问题
//                valid.add(item.locationName);
//            } else {
//                log.info("saveAllSuspectedLocations(): 调用百度地图api未找到地点 {} ，可能有误", item.locationName);
//            }
//        }
//
//        List<RealTimeWeiboAfterProcessing> trackList = afterProcessingMapper.getAllRealTimeWeiboAfterProcessing();
//        List<RealTimeWeiboDto> saveList = new ArrayList<>();
//        for (String item : valid) {
//            RealTimeWeiboDto dto = new RealTimeWeiboDto();
//            dto.setText(item);
//            int city = item.indexOf("市");
//            if (city != -1) {
//                // 可能加了市字段，把市字段去掉
//                item = item.substring(city + 1);
//            }
//            for (RealTimeWeiboAfterProcessing afp : trackList) {
//                if (afp.getText().contains(item)) {
//                    dto.setWeiboId(afp.getWeiboId());
//                    dto.setUserId(afp.getUserId());
//                    saveList.add(dto);
//                    break;
//                }
//            }
//        }
//
////        for (RealTimeWeiboDto dto : saveList) {
////            System.out.println(dto.getWeiboId());
////            System.out.println(dto.getUserId());
////            System.out.println(dto.getText());
////        }
////         保存
//        for (RealTimeWeiboDto dto : saveList) {
//            RealTimeWeiboFinal f = new RealTimeWeiboFinal();
//            f.setWeiboId(dto.getWeiboId());
//            f.setUserId(dto.getUserId());
//            f.setText(dto.getText());
//            // TODO:批量插入
//            finalMapper.insert(f);
//        }
    }

    @Override
    public ReverseGeocodingDto.Result getReverseGeocoding(Double lat, Double lng) throws JsonProcessingException {
        String url = "https://api.map.baidu.com/reverse_geocoding/v3/?location=" + lat + "," + lng + "&output=json&ak=" + ak;
        ResponseEntity<String> re = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//忽略未知字段
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);// 忽略字段大小写
        ReverseGeocodingDto reverseGeocoding = mapper.readValue(re.getBody(), ReverseGeocodingDto.class);
        return reverseGeocoding.getResult();
    }

    @Override
    public List<EightBlogs> getRecoEightBlogs(Double lat, Double lng) throws JsonProcessingException {
        ReverseGeocodingDto.Result reverseGeocoding = getReverseGeocoding(lat, lng);
        String city = reverseGeocoding.getAddressComponent().getCity().replaceAll("市", "");
        log.info("getRecoEightBlogs(): city is {}", city);
        if (StringUtils.isNullOrEmpty(city)) { //未解析出城市名
            log.info("RealTimeWeiboServiceImpl getReverseGeocoding: city is empty");
            return eightBlogsMapper.selectByNumLimit10();
        }
        List<EightBlogs> eightBlogs = eightBlogsMapper.selectByNumAndLocLimit10(city);
        if (eightBlogs == null || eightBlogs.isEmpty()) { //未找到该市的新闻
            return eightBlogsMapper.selectByNumLimit10();
        }
        return eightBlogs;
    }

    @Override
    public SuspectedResultDto getSuspectedResult(String locationName) {
        RealTimeWeiboAfterProcessing wb = afterProcessingMapper.getWeiboByLocationName(locationName);
        SuspectedResultDto dto = new SuspectedResultDto();
        dto.setDiagnosisRate(Double.parseDouble(wb.getPositiveRate()));
        dto.setCloseRate(Double.parseDouble(wb.getClosedRate()));
        List<RealTimeWeibo> weibos = new ArrayList<>();
        List<SimpleWeiboDto> simple = JSONObject.parseArray(wb.getText(), SimpleWeiboDto.class);
        for (SimpleWeiboDto d : simple) {
            RealTimeWeibo cur = new RealTimeWeibo();
//            log.info("date:" + d.getCreatedAt());
            cur.setScreenName(d.getUserName());
            cur.setCreatedAt(d.getCreatedAt());
            cur.setText(d.getWeiboText());
            weibos.add(cur);
        }
        dto.setWeiboList(weibos);
        return dto;
    }


}

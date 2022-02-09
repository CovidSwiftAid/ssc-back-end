package com.shu.ssc.service.impl;

import com.alibaba.nacos.common.utils.ConcurrentHashSet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shu.ssc.common.dto.RealTimeWeiboDto;
import com.shu.ssc.dto.MapResponseDto;
import com.shu.ssc.entity.covid.*;
import com.shu.ssc.mapper.RealTimeWeiboAfterProcessingMapper;
import com.shu.ssc.mapper.RealTimeWeiboFinalMapper;
import com.shu.ssc.service.RealTimeWeiboService;
import com.shu.ssc.service.TracksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Override
    public List<String> getAllSuspectedLocations() {
        List<RealTimeWeiboAfterProcessing> trackList = afterProcessingMapper.getAllRealTimeWeiboAfterProcessing();

        List<String> res = new ArrayList<>();
        for (RealTimeWeiboAfterProcessing t : trackList) {
            String track = t.getText();
            Set<String> locations = new ConcurrentHashSet<>();
            String[] locs = track.substring(1, track.length() - 1).split(",");
            String city = null;
            for (String l : locs) {
                String after = l.replaceAll("\'", "").trim();
                // 记录市名
                if (after.charAt(after.length() - 1) == '市') {
                    if (city == null) city = after;
                    continue;
                }
                // 排除一些不正确的/太模糊的
                if (after.length() < 3 || after.contains("#") || after.contains("病例") || after.contains("阳性") || after.contains("报告") || after.contains("疫情")) continue;
                if (locations.isEmpty()) {
                    locations.add(after);
                    continue;
                }
                boolean add = true;
                for (String exist : locations) {
                    if (exist.contains(after)) {
                        if (exist.length() >= after.length()) {
                            // 已经有更详细的，不加
                            add = false;
                            break;
                        } else {
                            // 当前更详细，更新
                            locations.remove(exist);
                            locations.add(after);
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                if (add) {
                    locations.add(after);
                }
            }
            for (String l : locations) {
                if (city != null && !l.contains(city)) {
                    // 加上市名
                    l = city + l;
                }
                res.add(l);
//                System.out.print(l + ", ");
            }
        }

        // 再排除掉已有的
        // 时间复杂度很高，缓存起来比较好
        // TODO:放到redis里
        List<String> already = tracksService.getAllTracks();
        for (String item : res) {
            for (String al : already) {
                if (al.contains(item)) {
                    res.remove(item);
                    break;
                }
            }
        }

        return res;
    }



    @Override
    public List<MapResponseEntity> getAllSuspectedLocationsInCoordinates() throws JsonProcessingException {
        List<MapResponseEntity> res = new ArrayList<>();
        List<String> tracks = getAllSuspectedLocations();

        for (String track : tracks) {
            // https://api.map.baidu.com/geocoding/v3/?address=ADDRESS&output=json&ak=您的ak&callback=showLocation
            String url = "https://api.map.baidu.com/geocoding/v3/?address=" + track + "&output=json&ak=" + ak;
            ResponseEntity<String> re = restTemplate.getForEntity(url, String.class);
//            System.out.println("====== etForEntity(getUrl, String.class" + re.getBody());
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//忽略未知字段
            mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);// 忽略字段大小写
            MapResponseDto response = mapper.readValue(re.getBody(), MapResponseDto.class);
            MapResponseEntity entity = new MapResponseEntity(response);
            entity.setLocationName(track);
            res.add(entity);
        }

        return res;
    }


    @Override
    public void saveAllSuspectedLocations() throws JsonProcessingException {
        List<MapResponseEntity> res = getAllSuspectedLocationsInCoordinates();
        List<String> valid = new ArrayList<>();
        for (MapResponseEntity item : res) {
//            System.out.println(item.locationName + ",  " + item.mapResponseDto.getStatus());
            if (item.mapResponseDto.getStatus() == 0) {
                // 找到，说明没有问题
                valid.add(item.locationName);
            } else {
                log.info("saveAllSuspectedLocations(): 调用百度地图api未找到地点 {} ，可能有误", item.locationName);
            }
        }

        List<RealTimeWeiboAfterProcessing> trackList = afterProcessingMapper.getAllRealTimeWeiboAfterProcessing();
        List<RealTimeWeiboDto> saveList = new ArrayList<>();
        for (String item : valid) {
            RealTimeWeiboDto dto = new RealTimeWeiboDto();
            dto.setText(item);
            int city = item.indexOf("市");
            if (city != -1) {
                // 可能加了市字段，把市字段去掉
                item = item.substring(city + 1);
            }
            for (RealTimeWeiboAfterProcessing afp : trackList) {
                if (afp.getText().contains(item)) {
                    dto.setWeiboId(afp.getWeiboId());
                    dto.setUserId(afp.getUserId());
                    saveList.add(dto);
                    break;
                }
            }
        }

//        for (RealTimeWeiboDto dto : saveList) {
//            System.out.println(dto.getWeiboId());
//            System.out.println(dto.getUserId());
//            System.out.println(dto.getText());
//        }
//         保存
        for (RealTimeWeiboDto dto : saveList) {
            RealTimeWeiboFinal f = new RealTimeWeiboFinal();
            f.setWeiboId(dto.getWeiboId());
            f.setUserId(dto.getUserId());
            f.setText(dto.getText());
            // TODO:批量插入
            finalMapper.insert(f);
        }
    }
}

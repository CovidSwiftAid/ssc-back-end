package com.shu.ssc.service.impl;

import com.alibaba.nacos.common.utils.ConcurrentHashSet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shu.ssc.dto.MapResponseDto;
import com.shu.ssc.entity.covid.MapResponseEntity;
import com.shu.ssc.entity.covid.Tracks;
import com.shu.ssc.mapper.TracksMapper;
import com.shu.ssc.service.TracksService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author oxotn3
 * @create 2022-01-19
 * @description
 */
@Service
public class TracksServiceImpl implements TracksService {
    public static final String ak = "3uRTECEK0CChcOWsegpKVoDoPcVtV5Tk";

    @Resource
    TracksMapper tracksMapper;

    @Resource
    RestTemplate restTemplate;

    @Override
    public List<String> getAllTracks() {
        List<Tracks> trackList = tracksMapper.getAllTracks();
        List<String> res = new ArrayList<>();
        for (Tracks t : trackList) {
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
                if (after.length() < 3 || after.contains("#") || after.contains("病例") || after.contains("阳性") || after.contains("报告")) continue;
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
        return res;
    }

    @Override
    public List<MapResponseEntity> getAllTracksInCoordinates() throws JsonProcessingException {
        List<MapResponseEntity> res = new ArrayList<>();
        List<String> tracks = getAllTracks();

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


}

package com.shu.ssc.service.impl;

import com.shu.ssc.entity.covid.WeiboCCTVNews;
import com.shu.ssc.mapper.WeiboCCTVNewsMapper;
import com.shu.ssc.redis.CovidInfoKeys;
import com.shu.ssc.service.WeiboCCTVNewsService;
import com.shu.ssc.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oxotn3
 * @create 2021-12-26
 * @description
 */
@Service
@Slf4j
public class WeiboCCTVNewsServiceImpl implements WeiboCCTVNewsService {

    @Resource
    WeiboCCTVNewsMapper weiboCCTVNewsMapper;

    @Resource
    RedisUtil redisUtil;

    @Override
    public List<WeiboCCTVNews> getAllWeiboCCTVNews() {
        return weiboCCTVNewsMapper.getAllWeiboCCTVNews();
    }

    @Override
    public List<WeiboCCTVNews> getAllWeiboCCTVNewsFromRedis() {
        List<WeiboCCTVNews> weiboCCTVNewsList = (List<WeiboCCTVNews>) redisUtil.get(CovidInfoKeys.WeiboCCTVNewsKey.getKey());
        if (weiboCCTVNewsList == null) {
            log.info("getAllWeiboCCTVNewsFromRedis(): redis中无消息");
            weiboCCTVNewsList = getAllWeiboCCTVNews();
            // 缓存到redis中
            redisUtil.set(CovidInfoKeys.WeiboCCTVNewsKey.getKey(), weiboCCTVNewsList);
        }
        return weiboCCTVNewsList;
    }
}

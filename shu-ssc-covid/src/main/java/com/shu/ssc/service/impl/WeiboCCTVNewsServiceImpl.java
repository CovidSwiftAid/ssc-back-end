package com.shu.ssc.service.impl;

import com.shu.ssc.entity.covid.WeiboCCTVNews;
import com.shu.ssc.mapper.WeiboCCTVNewsMapper;
import com.shu.ssc.service.WeiboCCTVNewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oxotn3
 * @create 2021-12-26
 * @description
 */
@Service
public class WeiboCCTVNewsServiceImpl implements WeiboCCTVNewsService {

    @Resource
    WeiboCCTVNewsMapper weiboCCTVNewsMapper;

    @Override
    public List<WeiboCCTVNews> getAllWeiboCCTVNews() {
        return weiboCCTVNewsMapper.getAllWeiboCCTVNews();
    }
}

package com.shu.ssc.service.impl;

import com.shu.ssc.entity.covid.News;
import com.shu.ssc.mapper.NewsMapper;
import com.shu.ssc.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oxotn3
 * @create 2021-12-25
 * @description
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    NewsMapper newsMapper;

    @Override
    public List<News> getAllCovidNews() {
        return newsMapper.getAllNews();
    }

}

package com.shu.ssc.service;

import com.shu.ssc.entity.covid.News;

import java.util.List;

/**
 * @author oxotn3
 * @create 2021-12-25
 * @description
 */
public interface NewsService {
    List<News> getAllCovidNews();
}

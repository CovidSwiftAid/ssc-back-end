package com.shu.ssc.redis;

/**
 * @author oxotn3
 * @create 2021-12-28
 * @description
 */
public enum CovidInfoKeys {

    WeiboCCTVNewsKey("ssc:covid:weibo_cctv_news"),
    CovidNewsKey("ssc:covid:covid_news");

    private String key;

    CovidInfoKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}

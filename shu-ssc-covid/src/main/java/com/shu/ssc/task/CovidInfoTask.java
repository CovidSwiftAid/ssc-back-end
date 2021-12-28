package com.shu.ssc.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author oxotn3
 * @create 2021-12-26
 * @description
 */
@Component
public class CovidInfoTask {
    private static final Logger log = LoggerFactory.getLogger(CovidInfoTask.class);
    private int count = 0;

//    @Scheduled(cron = "* 0/12 * * * ?")  // 每12小时更新
    public void getCovidInfo() throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("src/main/resources/python/Get-Covid-Info.py");
        process.waitFor();
        process = Runtime.getRuntime().exec("src/main/resources/python/Get-Weibo-Info.py");
        process.waitFor();
        log.info("定时执行脚本更新疫情信息 ===> {}", count++);
    }


}

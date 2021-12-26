package com.shu.ssc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author oxotn3
 * @create 2021-12-25
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
public class CovidMain5001 {
    public static void main(String[] args){
        SpringApplication.run(CovidMain5001.class, args);
    }
}

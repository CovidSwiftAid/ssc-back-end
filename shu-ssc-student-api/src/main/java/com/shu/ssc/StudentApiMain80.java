package com.shu.ssc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author oxotn3
 * @create 2021-12-09
 * @description
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class StudentApiMain80 {
    public static void main(String[] args){
        SpringApplication.run(StudentApiMain80.class, args);
    }
}

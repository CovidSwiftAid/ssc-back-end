package com.shu.ssc;

import com.shu.ssc.utils.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author oxotn3
 * @create 2021-12-09
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableConfigurationProperties( value = { JwtUtil.class } )
public class AuthCenter20000 {
    public static void main(String[] args) {
        SpringApplication.run(AuthCenter20000.class, args);
    }
}

package com.shu.ssc.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.shu.ssc.dto.LoginResponseDto;
import com.shu.ssc.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author oxotn3
 * @create 2022-01-02
 * @description
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    RestTemplate restTemplate;

    @Override
    public LoginResponseDto login(String code) throws Exception {
        String getUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=wx346080c58fc7de16&secret=c156b608d31cf4c47358d5ee0c218109&js_code=" + code + "&grant_type=authorization_code";
        System.out.println("getUrl: " + getUrl);
        ResponseEntity<String> re = restTemplate.getForEntity(getUrl, String.class);
        System.out.println("====== etForEntity(getUrl, String.class" + re.getBody());
        ObjectMapper mapper = new ObjectMapper();
        LoginResponseDto res = mapper.readValue(re.getBody(), LoginResponseDto.class);
        System.out.println("====== etForEntity : " + res.getOpenid());
        return res;
    }
}

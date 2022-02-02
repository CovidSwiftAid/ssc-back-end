package com.shu.ssc.service;

import com.shu.ssc.dto.LoginResponseDto;

/**
 * @author oxotn3
 * @create 2022-01-02
 * @description
 */
public interface LoginService {
    LoginResponseDto login(String code) throws Exception;
}

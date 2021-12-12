package com.shu.ssc.service;

import com.shu.ssc.security.SecurityUser;
import com.shu.ssc.utils.exceptionUtils.NotFoundException;
import com.shu.ssc.utils.exceptionUtils.ParamErrorException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author oxotn3
 * @create 2021-12-09
 * @description
 */
public interface SecurityUserService {

    void authenticateAndAuthorize(SecurityUser securityUser) throws NotFoundException, ParamErrorException;
}

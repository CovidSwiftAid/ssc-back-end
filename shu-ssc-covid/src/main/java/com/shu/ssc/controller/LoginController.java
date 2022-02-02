package com.shu.ssc.controller;

import com.shu.ssc.common.result.Result;
import com.shu.ssc.common.result.ResultCode;
import com.shu.ssc.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author oxotn3
 * @create 2022-01-02
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/api/Login")
@Api(tags = "1-登录模块")
public class LoginController {

    @Resource
    LoginService loginService;

    @GetMapping("/loginByCode")
    @ApiOperation(value = "通过code登录，返回openId")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public Result loginByCode(@RequestParam String code) throws Exception {
        log.info("loginByCode(): 通过code登录，返回openId");
        String openid = loginService.login(code).getOpenid();
        if (openid == null) {
            return Result.failure(ResultCode.PARAM_IS_INVALID);
        }

        return Result.success(loginService.login(code).getOpenid());
    }
}

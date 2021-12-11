package com.shu.ssc.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shu.ssc.common.result.Result;
import com.shu.ssc.common.result.ResultCode;
import com.shu.ssc.dto.LoginDto;
import com.shu.ssc.entity.Student;
import com.shu.ssc.service.feignService.StudentService;
import com.shu.ssc.utils.JwtUtil;
import com.shu.ssc.utils.exceptionUtils.NotFoundException;
import com.shu.ssc.utils.exceptionUtils.ParamErrorException;
import com.shu.ssc.utils.feignUtils.ConvertUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author oxotn3
 * @create 2021-12-09
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/api/login")
@Api(tags = "0-认证模块")
public class LoginController {

    @Autowired
    StudentService studentService;

    @Autowired
    JwtUtil jwtUtil;

    @Value("${ssc-auth-center.jwt.secret}")
    String secret;

    @GetMapping("/test")
    @SentinelResource
    public String test() {
        return "hello" + secret;
    }

//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PostMapping("/student/byPassword")
    @ApiOperation(value = "登录")
    @ResponseBody
    @SentinelResource
    public Result loginByPassword(@RequestBody LoginDto loginDto, HttpServletResponse response) throws NotFoundException, ParamErrorException {
        LoginDto dto = new LoginDto(loginDto.getPhone(), loginDto.getPassword());
        // 通过studentSerivice远程调用student-api模块下的loginByPassword
        Student student = (Student) ConvertUtil.getFeignResult(studentService.loginByPassword(dto).getData(), new Student());
        if (student == null) {
            log.error("登陆失败");
            return Result.failure(ResultCode.USER_NOT_EXIST);
        }
        String jwt = jwtUtil.generateToken(student.getPhoneId(), student.getPassword(), "student");
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");
        log.info("登录成功");
        return Result.success(student);
    }

    @PostMapping("/feignTest")
    @ApiOperation(value = "openfeign test")
    @ResponseBody
    public Result feignTest() throws NotFoundException, ParamErrorException {
        LoginDto dto = new LoginDto("13564060822", "123321");
        // 通过studentSerivice远程调用student-api模块下的loginByPassword
        Student res = (Student) ConvertUtil.getFeignResult(studentService.loginByPassword(dto).getData(), new Student());
        return Result.success(res);
    }
}

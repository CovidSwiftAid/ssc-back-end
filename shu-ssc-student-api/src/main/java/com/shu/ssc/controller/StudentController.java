package com.shu.ssc.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.shu.ssc.common.result.Result;
import com.shu.ssc.dto.LoginDto;
import com.shu.ssc.entity.Student;
import com.shu.ssc.service.StudentService;
import com.shu.ssc.utils.exceptionUtils.NotFoundException;
import com.shu.ssc.utils.exceptionUtils.ParamErrorException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

@Slf4j
@RestController
@RequestMapping("/api/Student")
@Api(tags = "1-学生模块")
public class StudentController {

    @Autowired
    StudentService studentService;


//    @GetMapping("/test")
//    @ApiOperation(value = "测试内网穿透接口")
//    public Result test() {
//        String info = "success";
//        return Result.success(info);
//    }


    @PostMapping("/loginByPasswordForAuth")
    @ApiOperation(value = "远程服务调用登录")
    @ResponseBody
    @SentinelResource
    public Result loginByPassword(@RequestBody LoginDto loginDto) throws NotFoundException, ParamErrorException {
        Student student = studentService.loginByPassword(loginDto.getPhone(), loginDto.getPassword());
        LoginDto dto = new LoginDto(student.getPhoneId(), student.getPassword());
        log.info("远程服务调用: loginByPasswordForAuth");
        return Result.success(dto);
    }

//    @GetMapping("/getStudent")
//    @ApiOperation(value = "获取所有学生详情")
////	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
//    @ResponseBody
//    public Iterable<Student> findAll() {
//        return studentService.getAllStudents();
//    }


    @GetMapping("/getOneStudent")
    @ApiOperation(value = "获取一个学生")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public Student findOne(int id) {
        return studentService.getOne(id);
    }
}

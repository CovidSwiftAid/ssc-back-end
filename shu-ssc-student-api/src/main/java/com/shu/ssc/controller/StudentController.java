package com.shu.ssc.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.shu.ssc.common.dto.RegisterDto;
import com.shu.ssc.common.dto.StudentDto;
import com.shu.ssc.common.result.Result;
import com.shu.ssc.common.result.ResultCode;
import com.shu.ssc.common.dto.LoginDto;
import com.shu.ssc.entity.Student;
import com.shu.ssc.service.StudentService;
import com.shu.ssc.utils.RedisUtil;
import com.shu.ssc.utils.exceptionUtils.ExistedException;
import com.shu.ssc.utils.exceptionUtils.NotFoundException;
import com.shu.ssc.utils.exceptionUtils.ParamErrorException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/Student")
@Api(tags = "1-学生模块")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    private RedisUtil redisUtil;


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
        Student student = studentService.loginByPassword(loginDto.getPhoneId(), loginDto.getPassword());
        LoginDto dto = new LoginDto(student.getPhoneId(), student.getPassword());
        log.info("远程服务调用: loginByPasswordForAuth");
        return Result.success(dto);
    }

    @GetMapping("/getAllStudents")
    @ApiOperation(value = "获取所有学生详情")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public Iterable<Student> findAll() {
        return studentService.getAllStudents();
    }

    @PostMapping("/getStudentById")
    @ApiOperation(value = "获取当前学生信息")
//    @PreAuthorize("hasAnyAuthority('ROLE_STUDENT','ROLE_ADMIN')")
    @ResponseBody
//    public Result findById(@RequestParam("user_id") int userId, @RequestHeader("Authorization") String jwt) {
    public Result findById(@RequestParam("user_id") int userId) {
        Student student = studentService.getStudentById(userId);
        if (student == null) return Result.failure(ResultCode.USER_NOT_EXIST);
        return Result.success(student);
    }

    @PostMapping("/checkByPhoneId")
    @ApiOperation(value = "验证手机号是否被注册，未被注册则发送验证码 （涉及到sms暂不可用）")
    @ResponseBody
    public Result checkPhoneId(@RequestParam("phone_id") String phoneId) {
//        if (!studentService.phoneValid(phoneId)) {
//            smsController.sendCode(phoneId);
//            return Result.success();
//        } else {
//            return Result.failure(ResultCode.USER_HAS_EXISTED);
//        }
        return Result.failure(ResultCode.USER_NOT_EXIST);
    }

    @PostMapping("/addStudent")
    @ApiOperation(value = "验证成功后添加学生")
    @ResponseBody
    public Result add(@RequestBody RegisterDto registerDto) throws ExistedException {
//        if (registerDto.getCode().equals(redisUtil.get(registerDto.getPhone()))) {
//            studentService.addUser(registerDto.getPhone(), registerDto.getPassword());
//            log.info("添加用户成功");
//            return Result.success();
//        } else {
//            return Result.failure(ResultCode.PARAM_IS_INVALID);
//        }
        studentService.addUser(registerDto.getPhone(), registerDto.getPassword());
        log.info("添加用户成功");
        return Result.success();
    }

    @PostMapping("/completeStudentById")
    @ApiOperation(value = "完善学生信息")
//    @PreAuthorize("hasAnyAuthority('ROLE_STUDENT', 'ROLE_ADMIN')")
    @ResponseBody
    public Result complete(@RequestParam("user_id") Integer userId, @RequestBody StudentDto studentDto, @RequestHeader("Authorization") String jwt)
            throws NotFoundException {
        studentService.completeStudent(userId, studentDto);
        log.info("完善学生信息：id=" + userId);
        return Result.success();
    }



}

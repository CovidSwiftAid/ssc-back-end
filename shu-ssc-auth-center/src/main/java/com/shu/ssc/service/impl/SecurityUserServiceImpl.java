package com.shu.ssc.service.impl;


import com.shu.ssc.common.result.ResultCode;
import com.shu.ssc.dto.LoginDto;
import com.shu.ssc.entity.Student;
import com.shu.ssc.security.SecurityUser;
import com.shu.ssc.service.SecurityUserService;
import com.shu.ssc.service.feignService.StudentService;
import com.shu.ssc.utils.DateUtil;
import com.shu.ssc.utils.exceptionUtils.NotFoundException;
import com.shu.ssc.utils.exceptionUtils.ParamErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oxotn3
 * @create 2021-12-09
 * @description
 */
@Service
public class SecurityUserServiceImpl implements SecurityUserService {

    @Autowired
    StudentService studentService;

    @Override
    public void authenticateAndAuthorize(SecurityUser securityUser) throws NotFoundException, ParamErrorException {
        LoginDto dto = new LoginDto(securityUser.getPhoneId(), securityUser.getPassword());
        switch (securityUser.getType()) {//判断用户类型选择service
            case ("student"):
                Student student = (Student) studentService.loginByPassword(dto).getData();
                List<String> studentRoles = new ArrayList<>();
                studentRoles.add("ROLE_STUDENT");
                if (DateUtil.getNowDate().before(DateUtil.stringToDate(student.getVipDate()))) {//若学生是vip则授予vip权限
                    studentRoles.add("STUDENT_VIP");
                }
                securityUser.setRoles(studentRoles);
                break;
//            case ("teacher"):
//                Teacher teacher = teacherService.loginByPassword(securityUser.getPhoneId(), securityUser.getPassword());
//                List<String> teacherRoles = new ArrayList<>();
//                teacherRoles.add("ROLE_TEACHER");
//                securityUser.setRoles(teacherRoles);
//                break;
//            case ("admin"):
//                Admin admin = adminService.loginByPassword(securityUser.getPhoneId(),securityUser.getPassword());
//                List<String> adminRoles = new ArrayList<>();
//                adminRoles.add("ROLE_ADMIN");
//                securityUser.setRoles(adminRoles);
//                break;
            default:
                throw new NotFoundException(ResultCode.USER_NOT_EXIST);
        }
    }

}

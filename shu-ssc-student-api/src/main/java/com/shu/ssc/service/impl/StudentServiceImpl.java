package com.shu.ssc.service.impl;

import com.shu.ssc.common.result.ResultCode;
import com.shu.ssc.entity.Student;
import com.shu.ssc.mapper.StudentMapper;
import com.shu.ssc.service.StudentService;
import com.shu.ssc.utils.exceptionUtils.NotFoundException;
import com.shu.ssc.utils.exceptionUtils.ParamErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @author oxotn3
 * @create 2021-12-09
 * @description
 */
@Service
public class StudentServiceImpl implements StudentService {

//    @Autowired
//    StudentMapper studentMapper;

    @Override
    public Student loginByPassword(String phoneId, String password) throws NotFoundException, ParamErrorException {
//        Student student = studentMapper.getByPhoneId(phoneId);
//        if (student == null) {
//            throw new NotFoundException(ResultCode.USER_NOT_EXIST);
//        }
//        if (!password.equals(student.getPassword())) {
//            throw new ParamErrorException(ResultCode.USER_LOGIN_ERROR);
//        }
//        return student;
        return new Student("13564060822", "123321", new Timestamp(0));
    }
}

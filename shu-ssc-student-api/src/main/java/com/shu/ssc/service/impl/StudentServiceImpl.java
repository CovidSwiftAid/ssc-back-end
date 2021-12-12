package com.shu.ssc.service.impl;

import com.shu.ssc.common.dto.StudentDto;
import com.shu.ssc.common.result.ResultCode;
import com.shu.ssc.entity.Major;
import com.shu.ssc.entity.Student;
import com.shu.ssc.mapper.StudentMapper;
import com.shu.ssc.service.StudentService;
import com.shu.ssc.utils.exceptionUtils.ExistedException;
import com.shu.ssc.utils.exceptionUtils.NotFoundException;
import com.shu.ssc.utils.exceptionUtils.ParamErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author oxotn3
 * @create 2021-12-09
 * @description
 */
@Service
//@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student loginByPassword(String phoneId, String password) throws NotFoundException, ParamErrorException {
        Student student = studentMapper.getStudentByPhoneId(phoneId);
        if (student == null) {
            throw new NotFoundException(ResultCode.USER_NOT_EXIST);
        }
        if (!password.equals(student.getPassword())) {
            throw new ParamErrorException(ResultCode.USER_LOGIN_ERROR);
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }

    @Override
    public Student getStudentById(Integer userId) {
        return studentMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void addUser(String phoneId, String password) throws ExistedException {
        Student student = studentMapper.getStudentByPhoneId(phoneId);
        if (student != null) throw new ExistedException(ResultCode.USER_HAS_EXISTED);
        student = new Student();
        student.setPhoneId(phoneId);
        student.setPassword(password);
        studentMapper.insertSelective(student);
    }

    @Override
    public Student getStudentByPhoneId(String phoneId) {
        return studentMapper.getStudentByPhoneId(phoneId);
    }

    @Override
    public void completeStudent(Integer userId, StudentDto studentDto) throws NotFoundException {
        Student stu = studentMapper.selectByPrimaryKey(userId);
//        Major major =
        if (stu == null) {
            throw new NotFoundException(ResultCode.USER_NOT_EXIST);
        }
//        if (major == null) {
//            throw new NotFoundException(ResultCode.PARAM_IS_INVALID);
//        }
        stu.setNickname(studentDto.getNickname());
        stu.setSex(studentDto.getSex());
        stu.setSchool(studentDto.getSchool());
//        stu.setMajorId(major.getMajorId());
        stu.setGrade(studentDto.getGrade());
        stu.setStudentPicUrl(studentDto.getPicUrl());
        studentMapper.updateByPrimaryKeySelective(stu);
    }

}

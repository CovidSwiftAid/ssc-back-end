package com.shu.ssc.mapper;

import com.shu.ssc.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> getAllStudents();

    Student getStudentByPhoneId(String phoneId);
}
package com.shu.ssc.service;

import com.shu.ssc.common.dto.StudentDto;
import com.shu.ssc.entity.CourseComment;
import com.shu.ssc.entity.Student;
import com.shu.ssc.utils.exceptionUtils.ExistedException;
import com.shu.ssc.utils.exceptionUtils.NotFoundException;
import com.shu.ssc.utils.exceptionUtils.ParamErrorException;

import java.util.List;

/**
 * @author oxotn3
 * @create 2021-12-09
 * @description
 */
public interface StudentService {
    Student loginByPassword(String phoneId, String password) throws NotFoundException, ParamErrorException ;

    Student getStudentById(Integer userId);
//
    List<Student> getAllStudents();         //获取所有学生信息
//
//    boolean phoneValid(String phoneId);       //判断手机号是否被注册
//
    void addUser(String phoneId, String password) throws ExistedException;      //添加刚注册的学生

    Student getStudentByPhoneId(String phoneId);
//
//    void deleteStudentById(Integer userId);       //删除学生
//
    void completeStudent(Integer userId, StudentDto studentDto) throws NotFoundException;       //完善学生信息
//
//    //学生评论课程
//    void commentCourseByCourseId(CourseCommentDto courseCommentDto) throws NotFoundException, TasteException;
//
//    CourseComment getCourseCommentByStudentAndCourse(Integer userId, Integer courseId) throws NotFoundException;
//
//    void collectPreference(Integer userId, Integer[] prefersId);
//
//    List<StudentPreference> getAllPreferences(Integer userId);
//
//    String studentVip(Integer studentId, Integer type) throws NotFoundException, ParamErrorException;
//
//    void likeCourse(Integer studentId, Integer courseId) throws NotFoundException;
//
//    void cancelLikeCourse(Integer studentId, Integer courseId) throws NotFoundException;
//
//    StudentLikeCourse getLikeByStudentAndCourse(Integer studentId, Integer courseId) throws NotFoundException;
//
//    Page<StudentLikeCourse> getStudentLikeCourse(Pageable pageable, Integer studentId) throws NotFoundException;
//
//    String getStudentItemCfResult(Integer studentId) throws NotFoundException, TasteException;
}

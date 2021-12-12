package com.shu.ssc.service;

import com.shu.ssc.entity.Student;
import com.shu.ssc.utils.exceptionUtils.NotFoundException;
import com.shu.ssc.utils.exceptionUtils.ParamErrorException;

/**
 * @author oxotn3
 * @create 2021-12-09
 * @description
 */
public interface StudentService {
    public Student loginByPassword(String phoneId, String password) throws ParamErrorException, NotFoundException;

    public Student getOne(Integer id);
}

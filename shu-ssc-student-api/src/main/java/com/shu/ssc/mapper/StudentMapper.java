package com.shu.ssc.mapper;

import com.shu.ssc.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author oxotn3
 * @create 2021-12-09
 * @description
 */
@Mapper
public interface StudentMapper {

    public Student getOne(Integer id);
}

package com.shu.ssc.mapper;

import com.shu.ssc.entity.covid.EightBlogs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author oxotn3
 * @create 2022-01-19
 * @description
 */
@Mapper
public interface EightBlogsMapper {
    int deleteByPrimaryKey(String id);

    int insert(EightBlogs record);

    int insertSelective(EightBlogs record);

    EightBlogs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EightBlogs record);

    int updateByPrimaryKeyWithBLOBs(EightBlogs record);

    int updateByPrimaryKey(EightBlogs record);

    List<EightBlogs> getLatestNthBlog(int n);

    List<EightBlogs> getAllBlogs();

    List<EightBlogs> selectByNumAndLocLimit10(String city);

    List<EightBlogs> selectByNumLimit10();
}
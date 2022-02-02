package com.shu.ssc.service;

import com.shu.ssc.entity.covid.EightBlogs;

import java.util.List;

/**
 * @author oxotn3
 * @create 2022-01-19
 * @description
 */
public interface EightBlogsService {
    List<EightBlogs> getLatestNthBlog(int n);

    List<EightBlogs> getAllBlogs();
}

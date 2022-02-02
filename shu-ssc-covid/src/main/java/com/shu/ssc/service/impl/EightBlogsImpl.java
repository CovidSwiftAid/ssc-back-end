package com.shu.ssc.service.impl;

import com.shu.ssc.entity.covid.EightBlogs;
import com.shu.ssc.mapper.EightBlogsMapper;
import com.shu.ssc.service.EightBlogsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oxotn3
 * @create 2022-01-19
 * @description
 */
@Service
public class EightBlogsImpl implements EightBlogsService {
    @Resource
    EightBlogsMapper eightBlogsMapper;

    @Override
    public List<EightBlogs> getLatestNthBlog(int n) {
        return eightBlogsMapper.getLatestNthBlog(n);
    }

    @Override
    public List<EightBlogs> getAllBlogs() {
        return eightBlogsMapper.getAllBlogs();
    }
}

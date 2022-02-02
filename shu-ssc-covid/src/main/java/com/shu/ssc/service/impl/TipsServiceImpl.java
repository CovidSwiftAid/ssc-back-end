package com.shu.ssc.service.impl;

import com.shu.ssc.entity.covid.Tips;
import com.shu.ssc.mapper.TipsMapper;
import com.shu.ssc.service.TipsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author oxotn3
 * @create 2022-01-02
 * @description
 */
@Service
public class TipsServiceImpl implements TipsService {

    @Resource
    TipsMapper tipsMapper;

    @Override
    public Tips getOneTips() {
        Random random = new Random();
        return tipsMapper.selectByPrimaryKey(random.nextInt(12) + 1);
    }
}

package com.shu.ssc.service.impl;

import com.shu.ssc.entity.covid.Sumdom;
import com.shu.ssc.mapper.SumdomMapper;
import com.shu.ssc.service.SumdomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author oxotn3
 * @create 2021-12-25
 * @description
 */
@Service
public class SumdomServiceImpl implements SumdomService {
    @Resource
    SumdomMapper sumdomMapper;

    @Override
    public List<Sumdom> getAllSumdom() {
        PriorityQueue<Double> q = new PriorityQueue<Double>((a, b) -> (int) (b - a));
        return sumdomMapper.getAllSumdom();
    }
}

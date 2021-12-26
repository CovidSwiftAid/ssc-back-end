package com.shu.ssc.service.impl;

import com.shu.ssc.entity.covid.Province;
import com.shu.ssc.mapper.ProvinceMapper;
import com.shu.ssc.service.ProvinceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author oxotn3
 * @create 2021-12-25
 * @description
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Resource
    ProvinceMapper provinceMapper;

    @Override
    public List<Province> getAllProvince() {
        return provinceMapper.getAllProvince();
    }
}

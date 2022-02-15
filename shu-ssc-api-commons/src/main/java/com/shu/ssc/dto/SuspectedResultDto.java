package com.shu.ssc.dto;

import com.shu.ssc.entity.covid.RealTimeWeibo;
import lombok.Data;

import java.util.List;

/**
 * @author oxotn3
 * @create 2022-02-15
 * @description
 */
@Data
public class SuspectedResultDto {
    // 确诊率
    private double diagnosisRate;
    // 封闭率
    private double closeRate;
    // 含有指定地点的全部微博
    private List<RealTimeWeibo> weiboList;


}

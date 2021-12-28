package com.shu.ssc.controller;

import com.shu.ssc.common.result.Result;
import com.shu.ssc.redis.CovidInfoKeys;
import com.shu.ssc.service.NewsService;
import com.shu.ssc.service.ProvinceService;
import com.shu.ssc.service.SumdomService;
import com.shu.ssc.service.WeiboCCTVNewsService;
import com.shu.ssc.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author oxotn3
 * @create 2021-12-25
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/api/Covid")
@Api(tags = "2-疫情模块")
public class NewsController {

    @Resource
    ProvinceService provinceService;

    @Resource
    NewsService newsService;

    @Resource
    SumdomService sumdomService;

    @Resource
    WeiboCCTVNewsService weiboCCTVNewsService;


    @GetMapping("/getAllProvince")
    @ApiOperation(value = "获取所有省份详情")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public Result getAllProvince() {
        return Result.success(provinceService.getAllProvince());
    }

    @GetMapping("/getAllNews")
    @ApiOperation(value = "获取所有新闻详情")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public Result getAllNews() {
        return Result.success(newsService.getAllCovidNews());
    }

    @GetMapping("/getAllSumdom")
    @ApiOperation(value = "获取疫情统计信息")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public Result getAllSumdom() {
        return Result.success(sumdomService.getAllSumdom());
    }

    @GetMapping("/getWeiboCCTVNews")
    @ApiOperation(value = "获取央视新闻微博")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public Result getWeiboCCTVNews() {
        log.info("getWeiboCCTVNews(): 获取央视新闻微博");
        return Result.success(weiboCCTVNewsService.getAllWeiboCCTVNewsFromRedis());
    }




}

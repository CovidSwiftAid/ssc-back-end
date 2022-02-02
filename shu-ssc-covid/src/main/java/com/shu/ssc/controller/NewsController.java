package com.shu.ssc.controller;

import com.github.pagehelper.PageHelper;
import com.shu.ssc.common.result.Result;
import com.shu.ssc.redis.CovidInfoKeys;
import com.shu.ssc.service.*;
import com.shu.ssc.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    TipsService tipsService;

    @Resource
    EightBlogsService eightBlogsService;


    @GetMapping("/getAllProvince")
    @ApiOperation(value = "获取所有省份详情")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public Result getAllProvince(@RequestParam int pageNum, @RequestParam int pageSize) {
        log.info("getAllProvince(): 获取所有省份详情, 第" + pageNum + "页，每页大小" + pageSize);
        PageHelper.startPage(pageNum, pageSize);
        return Result.success(provinceService.getAllProvince());
    }

    @GetMapping("/getAllNews")
    @ApiOperation(value = "获取所有新闻详情")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public Result getAllNews(@RequestParam int pageNum, @RequestParam int pageSize) {
        log.info("getAllNews(): 获取所有新闻详情, 第" + pageNum + "页，每页大小" + pageSize);
        PageHelper.startPage(pageNum, pageSize);
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
    public Result getWeiboCCTVNews(@RequestParam int pageNum, @RequestParam int pageSize) {
        log.info("getWeiboCCTVNews(): 获取央视新闻微博, 第" + pageNum + "页，每页大小" + pageSize);
        PageHelper.startPage(pageNum, pageSize);
        return Result.success(weiboCCTVNewsService.getAllWeiboCCTVNews());
//        return Result.success(weiboCCTVNewsService.getAllWeiboCCTVNewsFromRedis());
    }

    @GetMapping("/getOneTips")
    @ApiOperation(value = "随机获取一条防疫贴士")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public Result getOneTips() {
        log.info("getOneTips(): 随机获取一条防疫贴士");
        return Result.success(tipsService.getOneTips());
    }

    @GetMapping("/getLatestNthBlog")
    @ApiOperation(value = "获取最新的N条微博")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public Result getLatestNthBlog(@RequestParam int n) {
        log.info("getLatestNthBlog(): 获取最新的N条微博");
        return Result.success(eightBlogsService.getLatestNthBlog(n));
    }

    @GetMapping("/getAllBlogs")
    @ApiOperation(value = "获取所有微博")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public Result getAllBlogs(@RequestParam int pageNum, @RequestParam int pageSize) {
        log.info("getAllBlogs(): 获取所有微博, 第" + pageNum + "页，每页大小" + pageSize);
        PageHelper.startPage(pageNum, pageSize);
        return Result.success(eightBlogsService.getAllBlogs());
    }


}

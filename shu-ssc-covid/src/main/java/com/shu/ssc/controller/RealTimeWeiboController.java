package com.shu.ssc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.mysql.cj.util.StringUtils;
import com.shu.ssc.common.result.Result;
import com.shu.ssc.common.result.ResultCode;
import com.shu.ssc.dto.ReverseGeocodingDto;
import com.shu.ssc.dto.SuspectedResultDto;
import com.shu.ssc.service.RealTimeWeiboService;
import com.shu.ssc.service.RiskPlaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author oxotn3
 * @create 2022-02-09
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/api/RealTime")
@Api(tags = "3-实时微博模块")
public class RealTimeWeiboController {

    @Resource
    RealTimeWeiboService realTimeWeiboService;

    @Resource
    RiskPlaceService riskPlaceService;

    @GetMapping("/getAllSuspectedLocations")
    @ApiOperation(value = "获取所有疑似地点")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public Result getAllSuspectedLocations() {
//        log.info("getAllTracks(): 获取所有活动轨迹, 第" + pageNum + "页，每页大小" + pageSize);
        log.info("getAllSuspectedLocations(): 获取所有疑似地点");
//        PageHelper.startPage(pageNum, pageSize);
        return Result.success(realTimeWeiboService.getAllSuspectedLocations());
    }

    @GetMapping("/getAllSuspectedLocationsInCoordinates")
    @ApiOperation(value = "获取所有疑似地点，以经纬度形式")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public Result getAllSuspectedLocationsInCoordinates() throws JsonProcessingException {
//        log.info("getAllTracks(): 获取所有活动轨迹, 第" + pageNum + "页，每页大小" + pageSize);
        log.info("getAllSuspectedLocations(): 获取所有疑似地点，以经纬度形式");
//        realTimeWeiboService.saveAllSuspectedLocations();
//        PageHelper.startPage(pageNum, pageSize);
        return Result.success(realTimeWeiboService.getAllSuspectedLocationsInCoordinates());
    }

    @GetMapping("/getSuspectedResult")
    @ApiOperation(value = "根据指定的疑似地点，返回相关信息")
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @ResponseBody
    public Result getSuspectedResult(@RequestParam String locationName) throws JsonProcessingException {
//        log.info("getAllTracks(): 获取所有活动轨迹, 第" + pageNum + "页，每页大小" + pageSize);
        log.info("getSuspectedResult(): 根据指定的疑似地点，返回相关信息");
        SuspectedResultDto result = realTimeWeiboService.getSuspectedResult(locationName);
//        PageHelper.startPage(pageNum, pageSize);
        return Result.success(result);
    }

    @GetMapping("/getReverseGeocoding")
    @ApiOperation(value = "逆地理编码,通过经纬度获取位置格式化信息")
    @ResponseBody
    public Result getReverseGeocoding(@RequestParam("lat") Double lat, @RequestParam("lng") Double lng) throws JsonProcessingException {
        log.info("getReverseGeocoding(): 逆地理编码,通过经纬度获取位置格式化信息");
        ReverseGeocodingDto.Result result = realTimeWeiboService.getReverseGeocoding(lat, lng);
        if (StringUtils.isNullOrEmpty(result.getFormattedAddress()) || result.getAddressComponent() == null) {
            return Result.failure(ResultCode.PARAM_IS_INVALID);
        }
        return Result.success(result.getAddressComponent());
    }

    @GetMapping("/getHighRiskPlace")
    @ApiOperation(value = "获取当前高风险地区信息")
    @ResponseBody
    public Result getHighRiskPlace() {
        log.info("getHighRiskPlace(): 获取当前高风险地区信息");
//        PageHelper.startPage(pageNum, pageSize);
        try {
            return Result.success(riskPlaceService.getHighRiskPlace());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Result.failure(ResultCode.UNKNOWN_ERROR);
        }
    }

    @GetMapping("/getMediumRiskPlace")
    @ApiOperation(value = "获取当前中风险地区信息")
    @ResponseBody
    public Result getMediumRiskPlace() {
        log.info("getMediumRiskPlace(): 获取当前中风险地区信息");
//        PageHelper.startPage(pageNum, pageSize);
        try {
            return Result.success(riskPlaceService.getMediumRiskPlace());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Result.failure(ResultCode.UNKNOWN_ERROR);
        }
    }

    @GetMapping("/getRecoEightBlogs")
    @ApiOperation(value = "推荐微博新闻")
    @ResponseBody
    public Result getRecoEightBlogs(@RequestParam("lat") Double lat, @RequestParam("lng") Double lng) throws JsonProcessingException {
        return Result.success(realTimeWeiboService.getRecoEightBlogs(lat, lng));
    }
}

package com.shu.ssc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shu.ssc.common.result.Result;
import com.shu.ssc.service.RealTimeWeiboService;
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
 * @create 2022-02-09
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/api/RealTime")
@Api(tags = "4-实时微博模块")
public class RealTimeWeiboController {

    @Resource
    RealTimeWeiboService realTimeWeiboService;

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
}

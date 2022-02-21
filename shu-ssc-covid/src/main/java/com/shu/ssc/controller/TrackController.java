package com.shu.ssc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.shu.ssc.common.result.Result;
import com.shu.ssc.common.result.ResultCode;
import com.shu.ssc.service.TracksService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author oxotn3
 * @create 2022-01-19
 * @description 活动轨迹
 */
@Slf4j
@RestController
@RequestMapping("/api/Track")
@Api(tags = "3-活动轨迹模块（已弃用）")
public class TrackController {
    @Resource
    TracksService tracksService;

//    @GetMapping("/getAllTracks")
//    @ApiOperation(value = "获取所有活动轨迹")
////	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
//    @ResponseBody
//    public Result getAllTracks() {
////        log.info("getAllTracks(): 获取所有活动轨迹, 第" + pageNum + "页，每页大小" + pageSize);
//        log.info("getAllTracks(): 获取所有活动轨迹");
////        PageHelper.startPage(pageNum, pageSize);
//        return Result.success(tracksService.getAllTracks());
//    }
//
//
//    @GetMapping("/getAllTracksInCoordinates")
//    @ApiOperation(value = "获取所有活动轨迹，以经纬度形式")
////	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
//    @ResponseBody
//    public Result getAllTracksInCoordinates() {
////        log.info("getAllTracksInCoordinates(): 获取所有活动轨迹，以经纬度形式, 第" + pageNum + "页，每页大小" + pageSize);
//        log.info("getAllTracksInCoordinates(): 获取所有活动轨迹，以经纬度形式");
//        try {
////            PageHelper.startPage(pageNum, pageSize);
//            return Result.success(tracksService.getAllTracksInCoordinates());
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return Result.failure(ResultCode.FETCH_TRACKS_ERROR);
//    }
}

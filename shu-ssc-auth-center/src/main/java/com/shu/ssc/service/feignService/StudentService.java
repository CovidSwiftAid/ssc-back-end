package com.shu.ssc.service.feignService;

import com.shu.ssc.common.result.Result;
import com.shu.ssc.dto.LoginDto;
import com.shu.ssc.entity.Student;
import com.shu.ssc.utils.exceptionUtils.NotFoundException;
import com.shu.ssc.utils.exceptionUtils.ParamErrorException;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author oxotn3
 * @create 2021-12-09
 * @description
 */
@Component
@FeignClient("ssc-student-api")
public interface StudentService {

    @PostMapping("/api/Student/loginByPasswordForAuth")
    @ResponseBody
    public Result loginByPassword(@RequestBody LoginDto loginDto) throws NotFoundException, ParamErrorException;
}

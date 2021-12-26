package com.shu.ssc.utils.feignUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

/**
 * @author oxotn3
 * @create 2021-12-11
 * @description 远程调用结果转换工具类
 */
@Log4j2
public class ConvertUtil {

    /**
     * 获取指定类对象
     *
     * @param result              远程调用结果
     * @param targetClassInstance 指定类对象实例
     * @return
     */
    public static Object getFeignResult(Object result, Object targetClassInstance) {
        ObjectMapper mapper = new ObjectMapper();  // 通过ObjectMapper获取映射
        try {
            Class<?> targetClass = Class.forName(targetClassInstance.getClass().getName());  // 获取指定对象类
            return mapper.convertValue(result, targetClass);
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        }
        return null;
    }

}

package com.shu.ssc.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author oxotn3
 * @create 2022-02-21
 * @description
 */
@Data
@NoArgsConstructor
@ToString
public class SimpleWeiboDto {
    String userName;
    String weiboText;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    Date createdAt;

}

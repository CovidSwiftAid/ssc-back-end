package com.shu.ssc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author oxotn3
 * @create 2022-01-19
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapRequestDto {
    // https://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-geocoding
    private String address; // 必须
    private String city;
    private String ret_coordtype;
    private String ak = "3uRTECEK0CChcOWsegpKVoDoPcVtV5Tk"; // 必须
    private String sn;
    private String output;
    private String callback;
}

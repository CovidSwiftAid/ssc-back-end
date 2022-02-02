package com.shu.ssc.dto;

import lombok.Data;

/**
 * @author oxotn3
 * @create 2022-01-19
 * @description
 */
@Data
public class MapResponseDto {
    private int status;
    private Result result;

    @Data
    class Result {
        private Location location;
        private int precise;
        private int confidence;
        private int comprehension;
        private String level;

        @Data
        class Location {
            float lat;
            float lng;
        }
    }
}

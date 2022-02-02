package com.shu.ssc.entity.covid;

import com.shu.ssc.dto.MapResponseDto;
import lombok.Data;

/**
 * @author oxotn3
 * @create 2022-01-27
 * @description
 */
@Data
public class MapResponseEntity {
    public MapResponseDto mapResponseDto;
    public String locationName;
    public MapResponseEntity(MapResponseDto dto) {
        this.mapResponseDto = dto;
    }
}

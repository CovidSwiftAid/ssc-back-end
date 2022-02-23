package com.shu.ssc.common.dto;

import com.shu.ssc.dto.MapResponseDto;
import com.shu.ssc.entity.covid.RiskPlace;
import lombok.Data;

/**
 * @author oxotn3
 * @create 2022-02-23
 * @description
 */
@Data
public class RiskPlaceDto {

    public RiskPlace riskPlace;

    public MapResponseDto mapResponseDto;
}

package com.shu.ssc.mapper;

import com.shu.ssc.entity.covid.Tracks;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author oxotn3
 * @create 2022-01-19
 * @description
 */
@Mapper
public interface TracksMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tracks record);

    int insertSelective(Tracks record);

    Tracks selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tracks record);

    int updateByPrimaryKeyWithBLOBs(Tracks record);

    List<Tracks> getAllTracks();
}

package com.shu.ssc.mapper;

import com.shu.ssc.entity.ItemBasedCfResult;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemBasedCfResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemBasedCfResult record);

    int insertSelective(ItemBasedCfResult record);

    ItemBasedCfResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemBasedCfResult record);

    int updateByPrimaryKeyWithBLOBs(ItemBasedCfResult record);

    int updateByPrimaryKey(ItemBasedCfResult record);
}
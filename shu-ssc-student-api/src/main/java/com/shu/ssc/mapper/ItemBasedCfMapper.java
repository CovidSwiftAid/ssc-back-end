package com.shu.ssc.mapper;

import com.shu.ssc.entity.ItemBasedCf;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemBasedCfMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemBasedCf record);

    int insertSelective(ItemBasedCf record);

    ItemBasedCf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemBasedCf record);

    int updateByPrimaryKey(ItemBasedCf record);
}
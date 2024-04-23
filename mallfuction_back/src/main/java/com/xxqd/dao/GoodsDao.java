package com.xxqd.dao;

import com.xxqd.entity.GoodsList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsDao {
    @Select("select * from shoplist")
    List<GoodsList> selectAll();
}

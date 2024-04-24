package com.xxqd.dao;

import com.xxqd.entity.GoodsList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GoodsDao {
    @Select("select * from shoplist")
    List<GoodsList> selectAll();

    @Update("update shoplist set name = #{name},amount = #{amount} where id = #{id}")
    Integer updateGoods(GoodsList goodsList);

    @Insert("insert into shoplist(name,amount) values(#{name},#{amount}) ")
    Integer addNewList(GoodsList goodsList);
}

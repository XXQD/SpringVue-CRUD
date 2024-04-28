package com.xxqd.dao;

import com.xxqd.entity.GoodsList;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsDao {
    @Select("select * from shoplist")
    List<GoodsList> selectAll();

    @Update("update shoplist set name = #{name},amount = #{amount} where id = #{id}")
    Integer updateGoods(GoodsList goodsList);

    @Insert("insert into shoplist(name,amount) values(#{name},#{amount}) ")
    Integer addNewList(GoodsList goodsList);

    @Delete("delete from shoplist where id = #{id}")
    Integer deleteGood(Integer id);

    @Select("select * from shoplist where name like CONCAT('%',#{name},'%')")
    List<GoodsList> selectByName(String name);
}

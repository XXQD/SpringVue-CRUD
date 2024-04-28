package com.xxqd.service;

import com.xxqd.entity.GoodsList;

import java.util.List;

public interface GoodsListService {
    List<com.xxqd.entity.GoodsList> selectAll();

    Integer updateInfo(GoodsList goodsList);

    Integer addNewList(GoodsList goodsList);

    Integer deleteGood(Integer id);

    List<GoodsList> selectByName(String name);
}

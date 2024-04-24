package com.xxqd.service;

import com.xxqd.entity.GoodsList;

import java.util.List;

public interface GoodsListService {
    List<com.xxqd.entity.GoodsList> selectAll();

    Integer updateInfo(GoodsList goodsList);

    Integer addNewList(GoodsList goodsList);
}

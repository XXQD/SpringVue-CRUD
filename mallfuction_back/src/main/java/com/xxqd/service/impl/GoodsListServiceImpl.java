package com.xxqd.service.impl;

import com.xxqd.dao.GoodsDao;
import com.xxqd.service.GoodsListService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsListServiceImpl implements GoodsListService {
    @Resource
    private GoodsDao goodsDao;
    @Override
    public List<com.xxqd.entity.GoodsList> selectAll() {
        return goodsDao.selectAll();
    }
}

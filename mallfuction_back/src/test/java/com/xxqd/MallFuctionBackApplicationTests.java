package com.xxqd;

import com.xxqd.dao.GoodsDao;
import com.xxqd.entity.GoodsList;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MallFuctionBackApplicationTests {

    @Resource
    GoodsDao goodsDao;
    @Test
    void contextLoads() {
        List<GoodsList> goodsLists = goodsDao.selectAll();
        System.out.println(goodsLists);
    }

}

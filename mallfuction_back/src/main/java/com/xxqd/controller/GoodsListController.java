package com.xxqd.controller;

import com.alibaba.fastjson.JSONObject;
import com.xxqd.entity.GoodsList;
import com.xxqd.entity.Result;
import com.xxqd.service.GoodsListService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")

public class GoodsListController {
    @Resource
    private GoodsListService service;

    @GetMapping("/search")
    public Result searchTest(){
        return Result.success(service.selectAll());
    }

    @PutMapping("/update")
    public Result updateTest(@RequestBody GoodsList goodsList){
        return Result.success(service.updateInfo(goodsList));
    }

    @PostMapping("/add")
    public Result addTest(@RequestBody GoodsList goodsList){
        return Result.success(service.addNewList(goodsList));
    }
}
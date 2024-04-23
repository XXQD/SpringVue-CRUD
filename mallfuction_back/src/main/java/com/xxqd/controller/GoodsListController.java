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
    @CrossOrigin
    @GetMapping("/search")
    public Result searchTest(){
        return Result.success(service.selectAll());
    }
}

package com.xxqd.controller;

import com.xxqd.entity.GoodsList;
import com.xxqd.entity.Result;
import com.xxqd.service.GoodsListService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete/{id}")
    public Result deleteTest(@PathVariable Integer id){
        return Result.success(service.deleteGood(id));
    }

    @GetMapping("/searchByName/{name}")
    public Result searchByName(@PathVariable String name){
        return Result.success(service.selectByName(name));
    }

}
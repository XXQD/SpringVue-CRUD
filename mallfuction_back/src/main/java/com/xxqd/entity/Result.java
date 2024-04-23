package com.xxqd.entity;

import lombok.Data;

@Data
public class Result<T> {
    private T data;
    // 状态码可以单独定义成一个类 下面的方法使用了自定义
    private int status;
    private boolean success;

    public Result(T data,int status,boolean success){
        this.data = data;
        this.status = status;
        this.success = success;
    }

    public static <T> Result<T> success(){
        return new Result<>(null,200,true);
    }

    public static <T> Result<T> success(T data){
        return new Result<>(data,200,true);
    }

    public static <T> Result<T> failure(int status){
        return new Result<>(null,status,false);
    }

    // 这里的data是错误信息
    public static <T> Result<T> failure(int status,T data){
        return new Result<>(data,status,false);
    }
}

package com.xxqd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsList {

    private Integer id;
    private String name;
    private Integer amount;

    public GoodsList(String name,Integer amount){
        this.name = name;
        this.amount = amount;
    }
}

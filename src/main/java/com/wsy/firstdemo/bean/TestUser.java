package com.wsy.firstdemo.bean;

import lombok.*;

@ToString
@Data
@NoArgsConstructor  //无参构造器
@EqualsAndHashCode
//@AllArgsConstructor  //全参构造器
public class TestUser {
    private String name;

    private Pet pet;

    public TestUser(String name){
        this.name=name;
    }
}

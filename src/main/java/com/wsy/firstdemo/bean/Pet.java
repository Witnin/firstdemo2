package com.wsy.firstdemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor  //无参构造器
//@AllArgsConstructor  //全参构造器
public class Pet {
    private String name;
    private int age;

}

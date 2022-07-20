package com.atguigu.admin.bean;

import lombok.Data;

@Data
public class Account {

    private Long id;
    private String username;
    private String password;
    private int age;
    private char sex;
    private String email;
}

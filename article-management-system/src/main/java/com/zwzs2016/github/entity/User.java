package com.zwzs2016.github.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class User {
    private String username;
    private String password;
    private Date createtime;
    private boolean lock;

//    public User(String username, String password, Date createtime, boolean lock) {
//    }
}

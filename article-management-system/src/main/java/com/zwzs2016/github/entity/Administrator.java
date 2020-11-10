package com.zwzs2016.github.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Administrator {
    private String username;
    private String operation;
    private Date createtime;
    private String state;
}

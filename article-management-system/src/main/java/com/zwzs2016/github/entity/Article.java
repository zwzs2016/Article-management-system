package com.zwzs2016.github.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private String title;
    private String type;
    private String content;
    private String auth;
    private Date createtime;
}

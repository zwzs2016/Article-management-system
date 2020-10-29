package com.zwzs2016.github.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private String auth;
    private Date createtime;
}

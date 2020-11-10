package com.zwzs2016.github.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Comment {
    private String username;
    private String contents;
    private Integer likenum;
    private Date createtime;
}

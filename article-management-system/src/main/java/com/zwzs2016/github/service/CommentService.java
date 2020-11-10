package com.zwzs2016.github.service;

import com.zwzs2016.github.entity.Comment;

import java.util.List;

public interface CommentService {
    Boolean insertcomment(Comment comment);
    Boolean delete(String username);
    List<Comment> select(String title,String username);
}

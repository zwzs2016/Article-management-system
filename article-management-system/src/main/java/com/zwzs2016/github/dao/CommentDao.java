package com.zwzs2016.github.dao;

import com.zwzs2016.github.entity.Comment;

import java.util.List;

public interface CommentDao {
    Boolean insertcomment(Comment comment);
    Boolean delete(String username);
    List<Comment> select(String title,String username);
}

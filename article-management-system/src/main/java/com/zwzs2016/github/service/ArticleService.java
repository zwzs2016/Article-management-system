package com.zwzs2016.github.service;

import com.zwzs2016.github.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> selectAll();
    Boolean save(Article article);
    List<Article> select(String name,String values);
    Boolean delete(String title);
    Boolean update(Article article);
}

package com.zwzs2016.github.dao;

import com.zwzs2016.github.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

public interface ArticleDao {
    List<Article> selectAll();
    Boolean save(Article article);
    List<Article> select(String name,String values);
    Boolean delete(String title);
    Boolean update(Article article);
}

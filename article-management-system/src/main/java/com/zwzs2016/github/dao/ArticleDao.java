package com.zwzs2016.github.dao;

import com.zwzs2016.github.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

public interface ArticleDao {
    List<Article> findAll();
}

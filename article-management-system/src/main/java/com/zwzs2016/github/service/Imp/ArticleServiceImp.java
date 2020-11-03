package com.zwzs2016.github.service.Imp;

import com.zwzs2016.github.dao.ArticleDao;
import com.zwzs2016.github.entity.Article;
import com.zwzs2016.github.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImp implements ArticleService {
    @Autowired
    ArticleDao articledao;
    @Override
    public List<Article> selectAll() {
        return articledao.selectAll();
    }

    @Override
    public Boolean save(Article article) {
        return articledao.save(article);
    }

    @Override
    public List<Article> select(String name,String values) {
        return articledao.select(name,values);
    }

    @Override
    public Boolean delete(String title) {
        return articledao.delete(title);
    }

    @Override
    public Boolean update(Article article) {
        return articledao.update(article);
    }
}

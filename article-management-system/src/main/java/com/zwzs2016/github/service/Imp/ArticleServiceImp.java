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
    public List<Article> getarticlelist() {
        return articledao.findAll();
    }
}

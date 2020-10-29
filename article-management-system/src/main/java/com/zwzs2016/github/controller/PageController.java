package com.zwzs2016.github.controller;

import com.zwzs2016.github.entity.Article;
import com.zwzs2016.github.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {
    @Autowired
    ArticleService articleService;
    @GetMapping("/article")
    public ModelAndView article(){
        List<Article> articlelist = articleService.getarticlelist();
        Map<String,List> map=new HashMap<>();
        map.put("value",articlelist);
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }
}

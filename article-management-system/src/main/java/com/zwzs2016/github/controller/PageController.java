package com.zwzs2016.github.controller;

import com.zwzs2016.github.entity.Article;
import com.zwzs2016.github.entity.Comment;
import com.zwzs2016.github.entity.User;
import com.zwzs2016.github.service.ArticleService;
import com.zwzs2016.github.service.CommentService;
import com.zwzs2016.github.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.*;

@CrossOrigin
@RestController
public class PageController {
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    @GetMapping("/article")
    public ModelAndView article(){
        List<Article> articlelist = articleService.selectAll();
        Map<String,List> map=new HashMap<>();
        map.put("value",articlelist);
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }
    @PostMapping("/register")
    public Boolean register(@RequestBody Map<String,String> map){
        String username = map.get("username");
        String password = map.get("password");
        System.out.println(username);
        boolean lock = false;
        long createtime=new Date().getTime();
        System.out.println(createtime);
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setCreatetime(new java.sql.Date(createtime));
        user.setLock(lock);
        Boolean isexist = userService.isexist(username);
        if (isexist){
            return false;
        }else {
            return userService.insertuser(user);
        }
    }
    @PostMapping("/login")
    public Boolean login(@RequestBody Map<String,String> map){
        String username = map.get("username");
        String password = map.get("password");
        System.out.println(username);
        return userService.islogin(username,password);
    }
    @PostMapping("/publish")
    public Boolean publish(@RequestBody Map<String,String> map){
        String title = map.get("title");
        String type = map.get("type");
        String content = map.get("content");
        String auth = map.get("auth");
        System.out.println("content:"+content);
        java.sql.Date createtime=new java.sql.Date(new Date().getTime());
        Article article=new Article();
        article.setTitle(title);
        article.setType(type);
        article.setContent(content);
        article.setAuth(auth);
        article.setCreatetime(createtime);
        try {
            return articleService.save(article);
        }catch (DataAccessException e){
            System.out.println("title重复");
            return false;
        }
    }
    @GetMapping("/selectall")
    public HashMap<String, List> selectall(){
        List<Article> articles = articleService.selectAll();
        HashMap<String,List> map=new HashMap<>();
        map.put("vaules",articles);
        return map;
    }
    @CrossOrigin
    @GetMapping("/search")
    public HashMap<String,List> search(String title,String auth,String createtime){
        System.out.println(title);
        System.out.println(auth);
        System.out.println(createtime);
        HashMap<String,List> map=new HashMap<>();
        if (title!=null){
           List<Article> select = articleService.select("title",title);
           map.put("values",select);
           return map;
        }else if(auth!=null){
            List<Article> select = articleService.select("auth",auth);
            map.put("values",select);
            return map;
        }else {
            List<Article> select = articleService.select("createtime",createtime);
            map.put("values",select);
            return map;
        }
    }
    @GetMapping("/delete")
    public Boolean delete(String title){
        System.out.println(title);
        return articleService.delete(title);
    }
    @PostMapping("/update")
    public Boolean update(@RequestBody Map<String,String> map){
        String title = map.get("title");
        String type = map.get("type");
        String content = map.get("content");
        String auth = map.get("auth");
        Article article=new Article();
        article.setTitle(title);
        article.setType(type);
        article.setContent(content);
        article.setAuth(auth);
        return articleService.update(article);
    }
    @GetMapping("/commentselect")
    public Map<String,List> commentselect(String title,String username){
        Map<String,List> map=new HashMap<>();
        List<Comment> select = commentService.select(title,username);
        map.put("values",select);
        return map;
    }
}

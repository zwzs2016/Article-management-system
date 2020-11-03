package com.zwzs2016.github.dao;

import com.zwzs2016.github.entity.User;

public interface UserDao {
    Boolean isexist(String username);
    Boolean insertuser(User user);
    Boolean islogin(String username,String password);
}

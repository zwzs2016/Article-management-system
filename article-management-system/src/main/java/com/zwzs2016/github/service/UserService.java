package com.zwzs2016.github.service;

import com.zwzs2016.github.entity.User;

public interface UserService {
    Boolean isexist(String username);
    Boolean insertuser(User user);
    Boolean islogin(String username,String password);
}

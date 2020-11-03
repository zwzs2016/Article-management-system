package com.zwzs2016.github.service.Imp;

import com.zwzs2016.github.dao.UserDao;
import com.zwzs2016.github.entity.User;
import com.zwzs2016.github.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public Boolean isexist(String username) {
        return userDao.isexist(username);
    }

    @Override
    public Boolean insertuser(User user) {
        return userDao.insertuser(user);
    }

    @Override
    public Boolean islogin(String username, String password) {
        return userDao.islogin(username,password);
    }
}

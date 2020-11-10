package com.zwzs2016.github.service.Imp;

import com.zwzs2016.github.dao.CommentDao;
import com.zwzs2016.github.entity.Comment;
import com.zwzs2016.github.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    CommentDao commentDao;

    @Override
    public Boolean insertcomment(Comment comment) {
        return commentDao.insertcomment(comment);
    }

    @Override
    public Boolean delete(String username) {
        return commentDao.delete(username);
    }

    @Override
    public List<Comment> select(String title,String username) {
        return commentDao.select(title,username);
    }
}

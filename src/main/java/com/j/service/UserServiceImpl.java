package com.j.service;

import com.j.mapper.UserMapper;
import com.j.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    UserMapper userMapper;

    public User getUserInfo(String username){

        User user = new User();
        user.setUsername(username);
        user.setPassword("123");
        return user;
    }

    @Override
    public List<User> queryByall() {
        return userMapper.queryByall();
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public User queryById(String id) {
        return userMapper.queryById(id);
    }

}

package com.j.service;

import com.j.model.User;

import java.util.List;

public interface UserService {
    public User getUserInfo(String username);
    public List<User> queryByall();
    public void insert(User user);
    //根据id查询信息
    public User queryById(String id);

}

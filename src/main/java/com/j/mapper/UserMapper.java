package com.j.mapper;

import com.j.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    //获取所有用户信息
    @Select("SELECT * FROM t_user")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "username",  column = "username"),
            @Result(property = "password", column = "password")
    })
    public List<User> queryByall();

    //插入信息
    @Insert("insert into t_user(username,password) values(#{username},#{password})")
    public void insert(User user);

    //根据id查询信息
    public User queryById(String id);
}

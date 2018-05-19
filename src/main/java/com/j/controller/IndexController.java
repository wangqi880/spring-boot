package com.j.controller;

import com.j.common.BaseResponse;
import com.j.common.CodeConstraint;
import com.j.model.User;
import com.j.model.UserRequest;
import com.j.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    public String index(){
        return "hello";
    }

    @RequestMapping(value = "/get")
    public Object get(@Valid @ModelAttribute UserRequest userRequest, BindingResult bindingResult) {
        BaseResponse response = new BaseResponse();
        User user = new User();
        user.setUsername(userRequest.getUsername());
        response.setCode(CodeConstraint.SUCCESS);
        response.setInfo("success");
        response.setData(user);
        logger.info("调用成功");
        return response;
    }
    // @PathVariable 获得请求url中的动态参数
    @RequestMapping(value = "/getInfo/{username}")
    public User getUser(@PathVariable String username) {
        User user = userService.getUserInfo(username);
        return user;
    }

    @RequestMapping(value = "/alluser")
    public Object alluser(){
        List<User> list =  userService.queryByall();
        BaseResponse resp  = new BaseResponse();
        resp.setCode(CodeConstraint.SUCCESS);
        resp.setData(list);
        resp.setInfo("srucee");
        User user = new User();
        user.setUsername("nihao");
        user.setPassword("dajiahao");
        userService.insert(user);
        return resp;
    }

    @RequestMapping(value = "/userinfo/{id}")
    public Object userinfo(@PathVariable String id){
        BaseResponse resp  = new BaseResponse();
        resp.setInfo("success");
        resp.setCode(CodeConstraint.SUCCESS);
        User user = userService.queryById(id);
        resp.setData(user);
        return resp;
    }


    @RequestMapping("/error")
    public String aa() throws TimeoutException {
       /* throw new TimeoutException("i am time out");*/
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "nihao";
    }
}

package com.j.task;

import com.j.model.User;
import com.j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyUserTask extends DynamicScheduledTask {

    @Autowired
    UserService userService;

    @Override
    public void doBiz() {
       /* List<User> list =  userService.queryByall();
      System.out.println(list.toString());*/
    }
}

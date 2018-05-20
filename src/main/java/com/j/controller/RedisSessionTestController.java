package com.j.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @version 1.0 created by xxxx on 2018/5/20 23:17
 */
@RestController
public class RedisSessionTestController {

    @RequestMapping("/uid")
    public String uid(HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();


    }

}

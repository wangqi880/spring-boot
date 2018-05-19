package com.j.controller.huiController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HLogingController {

    @RequestMapping("/hLogin")
    public String  hLogin(){
        return "huiAdmin/login";
    }
    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public String  login(String username,String password){
        return "huiAdmin/login";
    }
}

package com.j.controller.huiController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HuiAdminController {
    @RequestMapping("/huiadmin")
    public String huiadmin(){
        return  "huiAdmin/index";
    }
}

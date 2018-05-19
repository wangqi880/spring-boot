package com.j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeoutException;

@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String   index(Model model, HttpSession session){

        model.addAttribute("message","wq");
        session.setAttribute("name","王琪");
        return  "adminView/admin";
    }

}

package com.j.controller.AmazeUiController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AmazeUiAdminController {

    @RequestMapping("/amazeUi/index")
    public String   index(Model model, HttpSession session){
        return  "amazeui/index";
    }
    @RequestMapping("/amazeUi/index2")
    public String   index2(Model model, HttpSession session){
        return  "amazeui/index2";
    }
    @RequestMapping("/amazeUi/index3")
    public String   index3(Model model, HttpSession session){
        return  "amazeui/index3";
    }

    @RequestMapping("/amazeUi/index4")
    public String   index4(Model model, HttpSession session){
        return  "amazeui/index4";
    }
    @RequestMapping("/amazeUi/index5")
    public String   index5(Model model, HttpSession session){
        return  "amazeui/index5";
    }
    @RequestMapping("/amazeUi/zhuce")
    public String   zhuce(Model model, HttpSession session){
        return  "amazeui/zhuce";
    }

    @RequestMapping("/amazeUi/admin/index")
    public String   adminIndex(Model model, HttpSession session){
        return  "amazeui/admin/index";
    }

    @RequestMapping("/amazeUi/admin/login")
    public String   adminLLogin(Model model, HttpSession session){
        return  "amazeui/admin/login";
    }
    @RequestMapping("/amazeUi/login")
    public String   login(Model model, HttpSession session){
        model.addAttribute("message","wq");
        session.setAttribute("name","王琪");
        return  "amazeui/login";
    }
}

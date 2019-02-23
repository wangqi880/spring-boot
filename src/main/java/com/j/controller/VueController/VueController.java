package com.j.controller.VueController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @version 1.0 created by xxxx on 2018/5/6 21:06
 */
@Controller
public class VueController {
    @RequestMapping("/static/vue/index")
    public String   index(Model model, HttpSession session){
        return  "vue/index";
    }
}

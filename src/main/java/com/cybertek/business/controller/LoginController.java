package com.cybertek.business.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    @GetMapping("/home")
    public String create(){

        return "home";
    }

    @GetMapping("/grocery")
    public String createPage(Model model){

        model.addAttribute("name","Baha Eklendi");

        return "grocery";
    }

    @GetMapping("/index")
    public String create1(){

        return "index";
    }
}

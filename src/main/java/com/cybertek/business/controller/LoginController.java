package com.cybertek.business.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {


    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @GetMapping("/home")
    public String create(){

        return "/home";
    }


    @GetMapping("/index")
    public String create1(){

        return "/index";
    }

    @GetMapping()
    public String homePage(){

        return "/home";
    }
}

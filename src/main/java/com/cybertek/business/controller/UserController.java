package com.cybertek.business.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {


    @GetMapping("/user-create")
    public String create(){

        return "pages/user/user-create";
    }

    @GetMapping("project-create")
    public String createPage(){

        return "pages/user/project-create";
    }
}

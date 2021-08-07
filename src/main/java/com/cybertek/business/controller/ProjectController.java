package com.cybertek.business.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {


    @GetMapping("/create")
    public String createProject(){

        return "/pages/project/project-create";
    }
}

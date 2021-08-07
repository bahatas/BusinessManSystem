package com.cybertek.business.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {


    @GetMapping("/create")
    public String createProject(){

        return "/pages/task/task-create";
    }
}

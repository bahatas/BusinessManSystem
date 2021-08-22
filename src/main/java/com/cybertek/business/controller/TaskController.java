package com.cybertek.business.controller;


import com.cybertek.business.dto.TaskDTO;
import com.cybertek.business.service.ProjectService;
import com.cybertek.business.service.TaskService;
import com.cybertek.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;

    @GetMapping("/create")
    public String createProject(Model model, TaskDTO taskDTO){

        model.addAttribute("task",new TaskDTO());
        model.addAttribute("projects",projectService.listAllProjects());
        model.addAttribute("employees",userService.listAllByRole("employee"));


        return "/pages/task/task-create";
    }

    @PostMapping("/create")
    public String saveProject( TaskDTO taskDTO){

       taskService.save(taskDTO);


        return "redirect:/task/create";
    }
    @GetMapping("/assign")
    public String taskassign(){

        return "/pages/manager/task-assign";
    }
}

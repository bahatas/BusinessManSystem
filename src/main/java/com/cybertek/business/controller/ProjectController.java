package com.cybertek.business.controller;


import com.cybertek.business.dto.ProjectDTO;
import com.cybertek.business.repository.ProjectRepository;
import com.cybertek.business.service.ProjectService;
import com.cybertek.business.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private ProjectService projectService;
    private UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createProject(Model model){

        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("listOfAllProjects",projectService.listAllProjects());
        model.addAttribute("managers",userService.listAllByRole("manager"));

        return "/pages/project/project-create";
    }


    @PostMapping("/create")
    public String postCreateProject(){

        return "/pages/project/project-create";
    }

    @GetMapping ("/update/{id}")
    public String updateProject (@PathVariable("id") String projectCode, Model model){

        return "/pages/project/project-update";
    }
}

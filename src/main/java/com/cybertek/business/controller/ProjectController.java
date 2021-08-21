package com.cybertek.business.controller;


import com.cybertek.business.dto.ProjectDTO;
import com.cybertek.business.repository.ProjectRepository;
import com.cybertek.business.service.ProjectService;
import com.cybertek.business.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.bind.annotation.*;

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

        System.out.println("projectService.listAllProjects() = " + projectService.listAllProjects());
        model.addAttribute("managers",userService.listAllByRole("manager"));

        return "/pages/project/project-create";
    }


    @PostMapping("/create")
    public String postCreateProject(ProjectDTO projectDTO){

        projectService.save(projectDTO);
        userService.save(projectDTO.getAssignedManager());
        return "redirect:/project/create";
    }

    @GetMapping ("/update/{projectCode}")
    public String updateProject (@PathVariable("projectCode") String projectCode, Model model){


        model.addAttribute("updatedProject",projectService.getByProjectCode(projectCode));
        model.addAttribute("listOfAllProjects",projectService.listAllProjects());
        model.addAttribute("managers",userService.listAllByRole("manager"));

        return "/pages/project/project-update";
    }

    @PostMapping ("/update/{projectCode}")
    public String updateProjectPost (@PathVariable("projectCode") String projectCode, Model model, ProjectDTO projectDTO){


        projectService.update(projectDTO);
        return "redirect:/project/create";
}

    @GetMapping("/delete/{projectCode}")
    public String delete(@PathVariable("projectCode") String projectCode){

        projectService.delete(projectCode);

        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectCode}")
    public String updateStatus(@PathVariable("projectCode") String projectCode){


        projectService.complete(projectCode);
        return "redirect:/project/create";
    }
}

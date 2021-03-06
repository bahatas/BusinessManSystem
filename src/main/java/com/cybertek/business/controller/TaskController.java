package com.cybertek.business.controller;


import com.cybertek.business.dto.TaskDTO;
import com.cybertek.business.enums.Status;
import com.cybertek.business.service.ProjectService;
import com.cybertek.business.service.TaskService;
import com.cybertek.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        model.addAttribute("tasks",taskService.listAllTasks());
        model.addAttribute("employees",userService.listAllByRole("employee"));


        return "/pages/task/task-create";
    }

    @PostMapping("/create")
    public String saveProject( TaskDTO taskDTO){

       taskService.save(taskDTO);


        return "redirect:/task/create";
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, TaskDTO taskDTO,Model model){

        model.addAttribute("task",new TaskDTO());
        model.addAttribute("projects",projectService.listAllProjects());
        model.addAttribute("tasks",taskService.listAllTasks());
        model.addAttribute("employees",userService.listAllByRole("employee"));
        model.addAttribute("taskToUpdate",taskService.findById(id));

        return "/pages/task/task-update";
    }

    @PostMapping("/update/{id}")
    public String updateSave(@PathVariable("id") Long id, TaskDTO taskDTO){
        taskService.update(taskDTO);

        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id,TaskDTO taskDTO){

        taskService.delete(id);

        return "redirect:/task/create";
    }

    @GetMapping("/employee")
    public String getEmployee(Model model){

        List<TaskDTO> taskList = taskService.listAllTasksBySttatusIsNot(Status.COMPLETE);

        model.addAttribute("employeetasklist",taskList);

        return "/pages/employee/pending-task";
    }


    @GetMapping("/emloyee/edit/{id}")
    public String edittask(Model model, @PathVariable("id") Long id) {
        List<TaskDTO> taskList = taskService.listAllTasksBySttatusIsNot(Status.COMPLETE);
        TaskDTO taskDTO = taskService.findById(id);

        model.addAttribute("taskbyid", taskDTO);
        model.addAttribute("employeetasklist", taskList);

        return "/templates/pages/employee/edit-pendingtasks";

    }

}

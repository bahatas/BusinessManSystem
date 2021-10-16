package com.cybertek.business.controller;


import com.cybertek.business.annotation.ExecutionTime;
import com.cybertek.business.dto.UserDTO;
import com.cybertek.business.service.RoleService;
import com.cybertek.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @GetMapping("/create")
    @ExecutionTime
    public String create(Model model) {

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.listAllRoles());
        model.addAttribute("userList", userService.listAllUser());

        return "pages/user/user-create";
    }

    @PostMapping("/create")
    @ExecutionTime
    public String insertUser(Model model, UserDTO userDTO) {

        userService.save(userDTO);
        return "redirect:/user/create";
    }

    @GetMapping("/update/{userName}")
    @ExecutionTime
    public String editUser(@PathVariable("userName") String username,Model model) {
        model.addAttribute("updatedUser", userService.findByUserName(username));
        model.addAttribute("userList", userService.listAllUser());
        model.addAttribute("roles", roleService.listAllRoles());

        return "pages/user/user-update";
    }


    @PostMapping("/update/{username}")
    @ExecutionTime
    public String updateUser(Model model, @PathVariable("username") String username,UserDTO userDTO) {
        userService.update(userDTO);

        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    @ExecutionTime
    public String deleteUSer(Model model, @PathVariable("username") String username) {


        userService.delete(username);

        return "redirect:/user/create";
    }
}

package com.cybertek.business.controller;


import com.cybertek.business.dto.RoleDTO;
import com.cybertek.business.dto.UserDTO;
import com.cybertek.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/create")
    public String create(Model model){

        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles",new RoleDTO());
        model.addAttribute("userList",userService.listAllUser());
        return "pages/user/user-create";
    }


}

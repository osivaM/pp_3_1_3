package com.github.osivaM.pp_3_1_3.controllers;

import com.github.osivaM.pp_3_1_3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String user(Principal principal, Model model) {
        model.addAttribute("user" , userService.getUserByName(principal.getName()));

        return "user";
    }

}

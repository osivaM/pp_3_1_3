package com.github.osivaM.pp_3_1_3.controllers;

import com.github.osivaM.pp_3_1_3.models.User;
import com.github.osivaM.pp_3_1_3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/authorization")
    public String getAuth() {
        return "auth/authorization";
    }

    @GetMapping("/registration")
    public String getRegistration(@ModelAttribute("user") User user) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") User user) {
        userService.createUser(user);

        return "redirect:/auth/authorization";
    }

}

package com.github.osivaM.pp_3_1_3.controllers;

import com.github.osivaM.pp_3_1_3.models.User;
import com.github.osivaM.pp_3_1_3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user")
    public String user(@AuthenticationPrincipal(expression = "user") User user, Model model) {
        model.addAttribute("user" , userService.getUserById(user.getId()));

        return "user";
    }

    @GetMapping("admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getUsers(Model model) {
        model.addAttribute("value", userService.getAllUsers());

        return "users";
    }

    @GetMapping("admin/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));

        return "update";
    }

    @PatchMapping("admin/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);

        return "redirect:/admin";
    }

    @DeleteMapping("admin/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);

        return "redirect:/admin";
    }

}

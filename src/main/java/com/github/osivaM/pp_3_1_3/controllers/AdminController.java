package com.github.osivaM.pp_3_1_3.controllers;

import com.github.osivaM.pp_3_1_3.models.Role;
import com.github.osivaM.pp_3_1_3.models.User;
import com.github.osivaM.pp_3_1_3.services.RoleService;
import com.github.osivaM.pp_3_1_3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final UserService userService;

    private final RoleService roleService;


    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("value", userService.getAllUsers());

        return "users";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());

        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user, @ModelAttribute("roles") Role role) {
        role.getUser().add(user);
        userService.createUser(user);

        return "redirect:/admin";
    }

    @GetMapping("/update/{id}")
    public String updateUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", roleService.getAllRoles());

        return "update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);

        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);

        return "redirect:/admin";
    }

}

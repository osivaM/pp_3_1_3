package com.github.osivaM.pp_3_1_3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/authorization")
    public String getAuth() {
        return "auth/authorization";
    }

}

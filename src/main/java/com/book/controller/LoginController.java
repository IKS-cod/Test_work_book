package com.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String getLogin(Model model) {
        return "login";
    }
}

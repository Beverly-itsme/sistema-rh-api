package com.rh.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // Página inicial - redireciona para login
    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    // Página de login
    @GetMapping("/login")
    public String login() {
        return "login"; // abre login.html
    }

    // Página do menu
    @GetMapping("/menu")
    public String menu() {
        return "menu"; // abre menu.html
    }
}
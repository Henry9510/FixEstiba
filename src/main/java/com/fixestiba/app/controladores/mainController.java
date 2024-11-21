package com.fixestiba.app.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    @GetMapping("/index")
    public String index() {
        return "index"; // Thymeleaf buscará index.html en la carpeta templates
    }

    @GetMapping("/usuarios")
    public String usuarios() {
        return "usuarios"; // Thymeleaf buscará usuarios.html en la carpeta templates
    }

    @GetMapping("/estibas")
    public String estibas() {
        return "estibas"; // Thymeleaf buscará estibas.html en la carpeta templates
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Thymeleaf buscará login.html en la carpeta templates
    }
}

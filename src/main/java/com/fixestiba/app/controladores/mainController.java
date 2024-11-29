package com.fixestiba.app.controladores;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class mainController {


    @GetMapping("/")
    public String home() {
        return "login"; // Devuelve login.html desde templates/
    }

    @GetMapping("/index")
    public String index() {
        return "index"; // Thymeleaf buscará index.html en la carpeta templates
    }

    @GetMapping("/usuarios")
    public String user() {
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

    @GetMapping("/prueba")
    public String test() {
        return "prueba"; // Thymeleaf buscará login.html en la carpeta templates
    }

}

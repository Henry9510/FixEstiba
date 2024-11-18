package com.fixestiba.app.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class mainController
{
    @GetMapping("/index")
    public String index() {
        return "index"; // Thymeleaf busca index.html en templates
    }

    @GetMapping("/usuarios")
    public String usuarios() {
        return "usuarios"; // Thymeleaf busca usuarios.html en templates
    }


    @GetMapping("/estibas")
    public String estibas() {
        return "estibas"; // Debe corresponder a index.html en templates
    }
    @GetMapping("/login")
    public String login() {
        return "login"; // Debe corresponder a index.html en templates
    }

    @GetMapping("/listar-estibas")
    public String listarEstibas() {
        return "listar-estibas"; // Debe corresponder a index.html en templates
    }


}

package com.fixestiba.app.controladores;

import com.fixestiba.app.modelos.Usuarios;
import com.fixestiba.app.serivicios.interfaces.Usuariosint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class mainController {


    @Autowired
    private Usuariosint userService;

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

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new Usuarios()); // Crear un nuevo objeto Usuarios en el modelo
        return "register"; // Mostrar el formulario de registro
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Usuarios user) {
        userService.registerUser(user); // Registrar al usuario
        return "redirect:/login"; // Redirigir al login después de registrar al usuario
    }
}

package com.fixestiba.app.controladores;

import com.fixestiba.app.modelos.Roles;
import com.fixestiba.app.repositorios.RolesRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RolesController {

    private final RolesRepository rolesRepository;

    public RolesController(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/api/roles")
    public List<Roles> obtenerRoles() {
        return rolesRepository.findAll();
    }

}

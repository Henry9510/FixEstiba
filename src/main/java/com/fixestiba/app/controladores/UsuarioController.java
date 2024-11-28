package com.fixestiba.app.controladores;


import java.util.List;
import java.util.Optional;

import com.fixestiba.app.modelos.Usuarios;
import com.fixestiba.app.repositorios.UsuarioRepository;
import com.fixestiba.app.serivicios.interfaces.Usuariosint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "http://127.0.0.1:5500") // Configuración global para este controlador
public class UsuarioController {
    private final UsuarioRepository repositorio;
    private final Usuariosint Servicio;

    public UsuarioController(UsuarioRepository repositorio, Usuariosint Servicio) {
        this.repositorio = repositorio;
        this.Servicio = Servicio;
    }

    @Autowired
    private Usuariosint servicio;

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        modelo.addAttribute("usuarios", servicio.listarUsuarios());
        return "index";
    }


    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerUsuario(@PathVariable Long id) {
        return repositorio.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Usuarios> guardarUsuario(@RequestBody Usuarios usuario) {
        Usuarios savedUsuario = repositorio.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable Long id, @RequestBody Usuarios usuarioActualizado) {
        return repositorio.findById(id)
                .map(existingUsuario -> {
                    existingUsuario.setNombre(usuarioActualizado.getNombre());
                    existingUsuario.setSegundo_nombre(usuarioActualizado.getSegundo_nombre());
                    existingUsuario.setApellido(usuarioActualizado.getApellido());
                    existingUsuario.setSegundo_apellido(usuarioActualizado.getSegundo_apellido());
                    existingUsuario.setUsername(usuarioActualizado.getUsername());
                    existingUsuario.setContrasenia(usuarioActualizado.getContrasenia());
                    existingUsuario.setCelular(usuarioActualizado.getCelular());
                    return ResponseEntity.ok(repositorio.save(existingUsuario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarUsuario(@PathVariable Long id) {
        if (!repositorio.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}




package com.fixestiba.app.controladores;


import java.util.List;
import java.util.Optional;

import com.fixestiba.app.modelos.Usuarios;
import com.fixestiba.app.repositorios.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class UsuarioController {
    private final UsuarioRepository repositorio;

    public UsuarioController(UsuarioRepository repositorio) {
        this.repositorio = repositorio;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/api/empleado")
    public List<Usuarios> obtenerEmpleados() {
        return repositorio.findAll();
    }



    @CrossOrigin(origins = "*")
    @GetMapping("/api/empleado/{id}")
    public ResponseEntity<Usuarios> obtenerEmpleado(@PathVariable Long id) {
        Optional<Usuarios> opt = repositorio.findById(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/api/empleado")
    public ResponseEntity<?> guardarEmpleado(@RequestBody Usuarios empleado) {
        Usuarios savedEmpleado = repositorio.save(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmpleado);


    }



    @PutMapping("/api/empleado/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Usuarios> actualizarEmpleado(@PathVariable Long id, @RequestBody Usuarios empleadoActualizado) {
        // Verificar si el empleado existe
        if (!repositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Obtener el empleado existente
        Usuarios existingEmpleado = repositorio.findById(id).orElse(null);

        if (existingEmpleado == null) {
            return ResponseEntity.notFound().build();
        }

        // Actualizar el empleado existente con los nuevos valores
        existingEmpleado.setNombre(empleadoActualizado.getNombre());
        existingEmpleado.setSegundo_nombre(empleadoActualizado.getSegundo_nombre());
        existingEmpleado.setApellido(empleadoActualizado.getApellido());
        existingEmpleado.setSegundo_apellido(empleadoActualizado.getSegundo_apellido());
        existingEmpleado.setEdad(empleadoActualizado.getEdad());
        existingEmpleado.setSexo(empleadoActualizado.getSexo());
        existingEmpleado.setTelefono(empleadoActualizado.getTelefono());
        existingEmpleado.setDireccion(empleadoActualizado.getDireccion());
        existingEmpleado.setEmail(empleadoActualizado.getEmail());
        existingEmpleado.setContrasenia(empleadoActualizado.getContrasenia());
        existingEmpleado.setCelular(empleadoActualizado.getCelular());
        existingEmpleado.setFecha_ingreso(empleadoActualizado.getFecha_ingreso());
        existingEmpleado.setCargo(empleadoActualizado.getCargo());

        // Guardar los cambios en la base de datos
        Usuarios updatedEmpleado = repositorio.save(existingEmpleado);

        return ResponseEntity.ok(updatedEmpleado);
    }


    @DeleteMapping("/api/empleado/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<Void> borrarEmpleado(@PathVariable Long id) {
        if (id == null || !repositorio.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }

        repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}




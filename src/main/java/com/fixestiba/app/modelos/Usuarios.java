package com.fixestiba.app.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@Entity
public class Usuarios {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cedula;
    private String nombre;
    private String apellido;
    private String segundo_nombre;
    private String segundo_apellido;
    private String celular;
    private String username;
    private String contrasenia;

   @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )

    private Collection<Roles> roles;

    public Usuarios() {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.segundo_nombre = segundo_nombre;
        this.segundo_apellido = segundo_apellido;
        this.celular = celular;
        this.username = username;
        this.contrasenia = contrasenia;
        this.roles = roles != null ? roles : new ArrayList<>();
    }


}



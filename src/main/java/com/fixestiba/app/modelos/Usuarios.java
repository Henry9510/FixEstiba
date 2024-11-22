package com.fixestiba.app.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Usuarios {


    @Id
    private Long cedula;

    private String nombre;
    private String apellido;
    private String segundo_nombre;
    private String segundo_apellido;
    private LocalDate fecha_ingreso;
    private int edad;
    private String sexo;
    private String direccion;
    private String email;
    private String usuario;
    private String contrasenia;
    private String celular;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roles_id")
    private Roles rolesid;


}

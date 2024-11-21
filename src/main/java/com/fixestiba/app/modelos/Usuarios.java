package com.fixestiba.app.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private String cargo;
    private int edad;
    private String sexo;
    private String telefono;
    private String direccion;
    private String email;
    private int contrasenia;
    private String celular;


}

package com.fixestiba.app.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRegistroDto {

    private Long id;
    private int cedula;
    private String nombre;
    private String apellido;
    private String segundo_nombre;
    private String segundo_apellido;
    private String username;
    private String contrasenia;
    private String celular;


    public UsuarioRegistroDto(Long id, int cedula, String nombre, String apellido, String segundo_nombre, String segundo_apellido, String username, String contrasenia, String celular) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.segundo_nombre = segundo_nombre;
        this.segundo_apellido = segundo_apellido;
        this.username = username;
        this.contrasenia = contrasenia;
        this.celular = celular;
    }


    public UsuarioRegistroDto() {

    }

}
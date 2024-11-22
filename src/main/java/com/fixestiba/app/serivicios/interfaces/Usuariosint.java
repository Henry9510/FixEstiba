package com.fixestiba.app.serivicios.interfaces;

import com.fixestiba.app.modelos.Usuarios;

import java.util.List;
import java.util.Optional;

public interface Usuariosint {


    public List<Usuarios> findAll();
    public Optional<Usuarios> findById(long id);
    public Usuarios save(Usuarios usuarios);
    public void delete(long id);
    public Optional<Usuarios> login(String usuario, String contrasenia);

}

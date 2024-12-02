package com.fixestiba.app.serivicios.interfaces;

import com.fixestiba.app.modelos.Personas;

import java.util.List;
import java.util.Optional;

public interface PersonasInt {

     List<Personas> findAll();
     Optional<Personas> findById(Integer id);
     Personas save(Personas persona);
     void delete(Integer id);
     Optional<Personas> login(String usuario, String contrasena);

}

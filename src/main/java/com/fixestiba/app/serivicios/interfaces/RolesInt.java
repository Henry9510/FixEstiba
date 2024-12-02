package com.fixestiba.app.serivicios.interfaces;

import com.fixestiba.app.modelos.Roles;

import java.util.List;
import java.util.Optional;

public interface RolesInt {

     List<Roles> findAll();
     Optional<Roles> findById(Integer id);


}


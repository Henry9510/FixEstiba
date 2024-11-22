package com.fixestiba.app.serivicios.interfaces;

import com.fixestiba.app.modelos.Roles;

import java.util.List;
import java.util.Optional;

public interface RolesInt {


    public List<Roles> findAll();
    public Optional<Roles> findById(long id);
    public Roles save(Roles roles);
    public void delete(long id);

}

package com.fixestiba.app.serivicios.Implementacion;

import com.fixestiba.app.modelos.Roles;
import com.fixestiba.app.repositorios.RolesRepository;
import com.fixestiba.app.serivicios.interfaces.RolesInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesImp implements RolesInt {

    @Autowired
    private RolesRepository repositorio;

    @Override
    public List<Roles> findAll(){
        return repositorio.findAll();
    }

    @Override
    public Optional<Roles> findById(Integer id) {
        return repositorio.findById(id);
    }



}
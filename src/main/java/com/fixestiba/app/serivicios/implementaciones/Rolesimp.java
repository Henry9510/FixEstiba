package com.fixestiba.app.serivicios.implementaciones;

import com.fixestiba.app.modelos.Roles;
import com.fixestiba.app.repositorios.RolesRepository;
import com.fixestiba.app.serivicios.interfaces.RolesInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Rolesimp implements RolesInt {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public List<Roles> findAll() {
        return rolesRepository.findAll();
    }

    @Override
    public Optional<Roles> findById(long id) {
        return rolesRepository.findById(id);
    }

    @Override
    public Roles save(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public void delete(long id) {
        rolesRepository.deleteById(id);
    }
}

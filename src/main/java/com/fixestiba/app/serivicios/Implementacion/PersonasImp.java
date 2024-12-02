package com.fixestiba.app.serivicios.Implementacion;


import com.fixestiba.app.modelos.Personas;
import com.fixestiba.app.repositorios.PersonasRepository;
import com.fixestiba.app.serivicios.interfaces.PersonasInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonasImp implements PersonasInt {

    @Autowired
    private PersonasRepository repositorio;

    @Override
    public List<Personas> findAll(){
        return repositorio.findAll();
    }

    @Override
    public Optional<Personas> login(String usuario, String contrasena) {
        Optional<Personas> persona = repositorio.findByUsuarioAndContrasena(usuario, contrasena);
        return persona;
    }
    @Override
    public Optional<Personas> findById(Integer id) {
        return repositorio.findById(id);
    }

    @Override
    public Personas save(Personas persona) {
        return repositorio.save(persona);
    }

    @Override
    public void delete(Integer id) {
        repositorio.deleteById(id);
    }

}

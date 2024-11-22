package com.fixestiba.app.serivicios.implementaciones;

import com.fixestiba.app.modelos.Usuarios;
import com.fixestiba.app.repositorios.UsuarioRepository;
import com.fixestiba.app.serivicios.interfaces.Usuariosint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Usuariosimp implements Usuariosint {


    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public List<Usuarios> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Usuarios> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Usuarios save(Usuarios usuarios) {
        return userRepository.save(usuarios);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<Usuarios> login(String usuario, String contrasenia) {
        return userRepository.findByUsuarioAndContrasenia(usuario, contrasenia);
    }

}

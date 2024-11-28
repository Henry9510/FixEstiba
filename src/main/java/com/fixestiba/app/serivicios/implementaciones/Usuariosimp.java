package com.fixestiba.app.serivicios.implementaciones;


import com.fixestiba.app.dto.UsuarioRegistroDto;
import com.fixestiba.app.modelos.Roles;
import com.fixestiba.app.modelos.Usuarios;
import com.fixestiba.app.security.UserDetailsAdapter;
import org.springframework.security.core.GrantedAuthority;
import com.fixestiba.app.repositorios.UsuarioRepository;
import com.fixestiba.app.serivicios.interfaces.Usuariosint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Usuariosimp implements Usuariosint {


    private final UsuarioRepository usuarioRepositorio;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private Usuariosimp(UsuarioRepository usuarioRepositorio, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    public static Usuariosimp createUsuariosimp(UsuarioRepository usuarioRepositorio, BCryptPasswordEncoder passwordEncoder) {
        return new Usuariosimp(usuarioRepositorio, passwordEncoder);
    }


    @Override
    public Usuarios registerUser(Usuarios user) {
        return null;
    }

    @Override
    public Usuarios guardar(UsuarioRegistroDto registroDTO) {
        if (usuarioRepositorio.findByUsername(registroDTO.getUsername()) != null) {
            throw new IllegalArgumentException("El usuario ya existe");
        }

        Usuarios usuario = new Usuarios(
                // Asignar rol por defecto
        );
        return usuarioRepositorio.save(usuario);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = usuarioRepositorio.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }

        return new UserDetailsAdapter(usuario);
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Roles> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Usuarios> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }
}

package com.fixestiba.app.serivicios.interfaces;

import com.fixestiba.app.dto.UsuarioRegistroDto;
import com.fixestiba.app.modelos.Usuarios;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface Usuariosint  extends UserDetailsService {


    Usuarios registerUser(Usuarios user);


    Usuarios guardar(UsuarioRegistroDto registroDTO);

    List<Usuarios> listarUsuarios();
}

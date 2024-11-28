package com.fixestiba.app.repositorios;

import com.fixestiba.app.modelos.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuarios, Long> {

    Usuarios findByUsername(String username);
}

package com.fixestiba.app.repositorios;

import com.fixestiba.app.modelos.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Roles findByNombre(String nombre);
}

package com.fixestiba.app.repositorios;


import org.springframework.data.jpa.repository.Query;

import com.fixestiba.app.modelos.Estiba;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
@Repository
public interface EstibaRepository extends CrudRepository<Estiba, Long> {


    @Query("SELECT COALESCE(SUM(e.cantidadTablas), 0) FROM Estiba e WHERE e.tipoEstiba = :tipo AND e.fecha = :fecha")
    int sumarTablasPorTipoYFecha(@Param("tipo") String tipo, @Param("fecha") LocalDate fecha);

    @Query("SELECT COALESCE(SUM(e.cantidadTacos), 0) FROM Estiba e WHERE e.tipoEstiba = :tipo AND e.fecha = :fecha")
    int sumarTacosPorTipoYFecha(@Param("tipo") String tipo, @Param("fecha") LocalDate fecha);

}

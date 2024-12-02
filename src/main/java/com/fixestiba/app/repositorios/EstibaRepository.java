package com.fixestiba.app.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fixestiba.app.modelos.Estiba;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EstibaRepository extends JpaRepository<Estiba, Long> {


    @Query("SELECT COALESCE(SUM(e.cantidadTablas), 0) FROM Estiba e WHERE e.tipoEstiba = :tipo AND e.fecha = :fecha")
    int sumarTablasPorTipoYFecha(@Param("tipo") String tipo, @Param("fecha") LocalDate fecha);

    @Query("SELECT COALESCE(SUM(e.cantidadTacos), 0) FROM Estiba e WHERE e.tipoEstiba = :tipo AND e.fecha = :fecha")
    int sumarTacosPorTipoYFecha(@Param("tipo") String tipo, @Param("fecha") LocalDate fecha);



    @Query("SELECT MONTH(e.fecha) as mes, " +
            "SUM(e.cantidadTablas) as totalTablas, " +
            "SUM(e.cantidadTacos) as totalTacos " +
            "FROM Estiba e " +
            "WHERE e.fecha BETWEEN :startDate AND :endDate " +
            "GROUP BY MONTH(e.fecha) " +
            "ORDER BY MONTH(e.fecha) DESC")
    List<Object[]> findTotalesPorMes(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}


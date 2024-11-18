package com.fixestiba.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fixestiba.app.modelos.Estiba;

public interface EstibaRepository extends JpaRepository<Estiba, Long> {
    @Query("SELECT SUM(e.cantidadTablas) FROM Estiba e WHERE e.tipoEstiba = :tipoEstiba")
    int sumTablasByTipoEstiba(String tipoEstiba);

    @Query("SELECT SUM(e.cantidadTacos) FROM Estiba e WHERE e.tipoEstiba = :tipoEstiba")
    int sumTacosByTipoEstiba(String tipoEstiba);


}

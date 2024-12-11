package com.fixestiba.app.repositorios;

import com.fixestiba.app.modelos.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {


    Stock findByTipoEstiba(String tipoEstiba);
}

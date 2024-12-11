package com.fixestiba.app.modelos;


import com.fixestiba.app.repositorios.EstibaRepository;
import com.fixestiba.app.serivicios.Implementacion.EstibaService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

@Setter
@Getter
@Entity
public class Estiba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoEstiba;  // Puede ser "grande", "mediana", "pequeña"
    private int cantidadTablas;
    private int cantidadTacos;
    private LocalDate fecha;  // Fecha del desarme o armada
    private int mes;  // Mes en que se realiza el desarme o armado
    private boolean desarme; // Indicador de si es desarme o armado

}

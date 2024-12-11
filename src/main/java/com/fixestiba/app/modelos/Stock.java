package com.fixestiba.app.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoEstiba;  // Puede ser "grande", "mediana", "pequeña"
    private int cantidadTablas;  // Cantidad de tablas disponibles
    private int cantidadTacos;   // Cantidad de tacos disponibles
    private LocalDate fecha;     // Fecha en que se registró el stock
}

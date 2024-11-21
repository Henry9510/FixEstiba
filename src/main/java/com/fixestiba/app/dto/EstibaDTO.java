package com.fixestiba.app.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class EstibaDTO {

    private LocalDate fecha;
    private int cantidadTablas;
    private int cantidadTacos;
    private String tipoEstiba;


}

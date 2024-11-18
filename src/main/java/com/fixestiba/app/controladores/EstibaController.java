package com.fixestiba.app.controladores;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fixestiba.app.modelos.Estiba;
import com.fixestiba.app.serivicios.EstibaService;


@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("/api/estibas")
public class EstibaController {

  
    @Autowired
    private EstibaService estibaService;

    @PostMapping("/crear")
    public Estiba crearEstiba(@RequestBody Estiba estiba) {
        return estibaService.crearEstiba(estiba);
    }

    @GetMapping("/totales/{tipoEstiba}")
    public int[] obtenerTotalesPorTipo(@PathVariable String tipoEstiba) {
        int totalTablas = estibaService.obtenerTotalTablasPorTipo(tipoEstiba);
        int totalTacos = estibaService.obtenerTotalTacosPorTipo(tipoEstiba);
        return new int[]{totalTablas, totalTacos};
    }
    
}

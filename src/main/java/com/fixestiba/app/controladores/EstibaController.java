package com.fixestiba.app.controladores;

import com.fixestiba.app.serivicios.Implementacion.EstibaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fixestiba.app.modelos.Estiba;
import com.fixestiba.app.repositorios.EstibaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/estibas")
public class EstibaController {

    @Autowired
    private EstibaRepository estibaRepository;

    @PostMapping("/crear")
    public Estiba crearEstiba(@RequestBody Estiba estiba) {
        return estibaRepository.save(estiba);
    }


    @GetMapping("/totales/{tipoEstiba}")
    public int[] obtenerTotalesPorTipoHoy(@PathVariable String tipoEstiba) {
        // Obtiene la fecha actual
        LocalDate fechaHoy = LocalDate.now();

        // Filtra las tablas y tacos por tipo y fecha
        int totalTablas = estibaRepository.sumarTablasPorTipoYFecha(tipoEstiba, fechaHoy);
        int totalTacos = estibaRepository.sumarTacosPorTipoYFecha(tipoEstiba, fechaHoy);

        // Retorna un array con los totales
        return new int[]{totalTablas, totalTacos};
    }

    @Autowired
    private EstibaService estibaService;

    @GetMapping("/totales/ultimosTresMeses")
    public ResponseEntity<List<Map<String, Object>>> obtenerTotalesUltimosTresMeses() {
        List<Map<String, Object>> totales = estibaService.obtenerTotalesUltimosTresMeses();
        return ResponseEntity.ok(totales);
    }
}


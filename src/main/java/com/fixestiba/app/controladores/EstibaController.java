package com.fixestiba.app.controladores;

import com.fixestiba.app.modelos.Stock;
import com.fixestiba.app.modelos.Estiba;
import com.fixestiba.app.repositorios.EstibaRepository;
import com.fixestiba.app.repositorios.StockRepository;
import com.fixestiba.app.serivicios.Implementacion.EstibaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/estibas")
public class EstibaController {

    // Inyección de dependencias
    @Autowired
    private EstibaService estibaService;

    @Autowired
    private StockRepository stockRepository;

    // Endpoint para crear un desarme o armado
    @PostMapping("/crear")
    public Estiba crearEstiba(@RequestBody Estiba estiba) {
        // Verificar si se trata de un armado, en cuyo caso verificamos el stock disponible
        if (!estiba.isDesarme() && !estibaService.verificarStockDisponible(estiba)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No hay suficiente stock disponible para armar.");
        }

        // Llamar al servicio para crear la estiba y actualizar los totales
        return estibaService.crearEstibaYActualizarTotales(estiba);
    }


    @GetMapping("/stock/dia/{tipo}/{fecha}")
    public Map<String, Integer> obtenerStockPorDia(@PathVariable String tipo, @PathVariable String fecha) {
        LocalDate fechaLocal = LocalDate.parse(fecha);  // Convierte el String en LocalDate
        int stockTablas = estibaRepository.obtenerStockTablasPorTipoYFecha(tipo, fechaLocal);
        int stockTacos = estibaRepository.obtenerStockTacosPorTipoYFecha(tipo, fechaLocal);

        Map<String, Integer> stock = new HashMap<>();
        stock.put("tablas", stockTablas);
        stock.put("tacos", stockTacos);

        return stock;
    }





    // Endpoint para consultar el stock disponible por tipo de estiba
    @GetMapping("/stock/{tipoEstiba}")
    public ResponseEntity<Stock> consultarStock(@PathVariable String tipoEstiba) {
        // Consultar el stock en la base de datos usando el tipo de estiba
        Stock stock = stockRepository.findByTipoEstiba(tipoEstiba);

        if (stock != null) {
            // Si se encuentra el stock, devolverlo con el código de estado OK
            return ResponseEntity.ok(stock);
        } else {
            // Si no se encuentra el stock, devolver un error 404 (No encontrado)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @Autowired
    private EstibaRepository estibaRepository;

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

    // Endpoint para obtener los totales de desarme en los últimos tres meses
    @GetMapping("/totales/ultimosTresMeses")
    public ResponseEntity<List<Map<String, Object>>> obtenerTotalesUltimosTresMeses() {
        List<Map<String, Object>> totales = estibaService.obtenerTotalesUltimosTresMeses();
        return ResponseEntity.ok(totales);
    }


    @GetMapping("/stock/mes")
    public List<Map<String, Object>> obtenerStockPorMes(@RequestParam String startDate, @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);  // Convierte el String en LocalDate
        LocalDate end = LocalDate.parse(endDate);

        List<Object[]> totalesPorMes = estibaRepository.findTotalesPorMes(start, end);

        List<Map<String, Object>> result = new ArrayList<>();
        for (Object[] row : totalesPorMes) {
            Map<String, Object> mesTotales = new HashMap<>();
            mesTotales.put("mes", row[0]);
            mesTotales.put("totalTablas", row[1]);
            mesTotales.put("totalTacos", row[2]);
            result.add(mesTotales);
        }

        return result;
    }

}

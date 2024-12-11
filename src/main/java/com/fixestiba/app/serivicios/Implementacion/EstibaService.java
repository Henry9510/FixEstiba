package com.fixestiba.app.serivicios.Implementacion;

import com.fixestiba.app.modelos.Estiba;
import com.fixestiba.app.modelos.Stock;
import com.fixestiba.app.repositorios.EstibaRepository;
import com.fixestiba.app.repositorios.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;
@Service
public class EstibaService {

    @Autowired
    private EstibaRepository estibaRepository;

    @Autowired
    private StockRepository stockRepository;

    // Crear estiba y actualizar el stock de tablas y tacos
    public Estiba crearEstibaYActualizarTotales(Estiba estiba) {
        // 1. Guardar la nueva estiba
        Estiba nuevaEstiba = estibaRepository.save(estiba);

        // 2. Actualizar el stock (sumar o restar las tablas y tacos)
        if (estiba.isDesarme()) {
            // Si es un desarme, sumamos las cantidades al stock
            actualizarStock(estiba, true); // true indica que es un desarme
        } else {
            // Si es armado, restamos las cantidades del stock
            actualizarStock(estiba, false); // false indica que es armado
        }

        return nuevaEstiba;
    }

    // Actualiza el stock de tablas y tacos según el tipo de estiba
    private void actualizarStock(Estiba estiba, boolean esDesarme) {
        String tipoEstiba = estiba.getTipoEstiba();
        int cantidadTablas = estiba.getCantidadTablas();
        int cantidadTacos = estiba.getCantidadTacos();

        // Buscar el stock actual para ese tipo de estiba
        Stock stock = stockRepository.findByTipoEstiba(tipoEstiba);

        if (stock != null) {
            // Si ya existe stock, actualizamos las cantidades dependiendo de si es desarme o armado
            if (esDesarme) {
                // Si es desarme, sumamos al stock
                stock.setCantidadTablas(stock.getCantidadTablas() + cantidadTablas);
                stock.setCantidadTacos(stock.getCantidadTacos() + cantidadTacos);
            } else {
                // Si es armado, restamos del stock
                stock.setCantidadTablas(stock.getCantidadTablas() - cantidadTablas);
                stock.setCantidadTacos(stock.getCantidadTacos() - cantidadTacos);
            }
            stockRepository.save(stock);  // Guardar el stock actualizado
        } else {
            // Si no existe stock, lo creamos (sumar si es desarme, restar si es armado)
            Stock nuevoStock = new Stock();
            nuevoStock.setTipoEstiba(tipoEstiba);
            if (esDesarme) {
                nuevoStock.setCantidadTablas(cantidadTablas);  // Sumar las cantidades de tablas
                nuevoStock.setCantidadTacos(cantidadTacos);   // Sumar las cantidades de tacos
            } else {
                nuevoStock.setCantidadTablas(-cantidadTablas);  // Restar las cantidades de tablas
                nuevoStock.setCantidadTacos(-cantidadTacos);    // Restar las cantidades de tacos
            }
            nuevoStock.setFecha(LocalDate.now());
            stockRepository.save(nuevoStock);
        }
    }

    // Verificar si hay suficiente stock antes de armar
    public boolean verificarStockDisponible(Estiba estiba) {
        String tipoEstiba = estiba.getTipoEstiba();
        int cantidadTablas = estiba.getCantidadTablas();
        int cantidadTacos = estiba.getCantidadTacos();

        // Obtener el stock actual para ese tipo de estiba
        Stock stock = stockRepository.findByTipoEstiba(tipoEstiba);
        if (stock == null) {
            return false;  // Si no existe stock
        }

        // Verificar si hay suficientes tablas y tacos disponibles
        return stock.getCantidadTablas() >= cantidadTablas && stock.getCantidadTacos() >= cantidadTacos;
    }

    public List<Map<String, Object>> obtenerTotalesUltimosTresMeses() {
        LocalDate hoy = LocalDate.now();
        LocalDate tresMesesAtras = hoy.minusMonths(3);

        // Obtener los totales por mes
        List<Object[]> resultados = estibaRepository.findTotalesDesarmeUltimosTresMeses(tresMesesAtras, hoy);

        // Convertir los resultados a una lista de mapas
        List<Map<String, Object>> totales = new ArrayList<>();
        for (Object[] resultado : resultados) {
            Map<String, Object> total = new HashMap<>();
            total.put("mes", resultado[0]);
            total.put("totalTablas", resultado[1]);
            total.put("totalTacos", resultado[2]);
            totales.add(total);
        }

        return totales;
    }

    // Obtener el nombre del mes
    private String obtenerNombreMes(int mes) {
        return Month.of(mes).getDisplayName(TextStyle.FULL, Locale.getDefault());
    }
}

package com.fixestiba.app.serivicios.Implementacion;

import com.fixestiba.app.repositorios.EstibaRepository;
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

    public List<Map<String, Object>> obtenerTotalesUltimosTresMeses() {
        LocalDate endDate = LocalDate.now(); // Hoy
        LocalDate startDate = endDate.minusMonths(3).withDayOfMonth(1); // Inicio de hace tres meses

        // Consultar los totales de tablas y tacos agrupados por mes
        List<Object[]> resultados = estibaRepository.findTotalesPorMes(startDate, endDate);

        // Convertir los resultados a una lista de mapas para el frontend
        List<Map<String, Object>> response = new ArrayList<>();
        for (Object[] row : resultados) {
            Map<String, Object> mesData = new HashMap<>();
            mesData.put("mes", obtenerNombreMes((Integer) row[0])); // row[0]: Número del mes
            mesData.put("tablas", row[1]); // row[1]: Total de tablas
            mesData.put("tacos", row[2]); // row[2]: Total de tacos
            response.add(mesData);
        }
        return response;
    }

    // Convertir número del mes a nombre
    private String obtenerNombreMes(int mes) {
        return Month.of(mes).getDisplayName(TextStyle.FULL, Locale.getDefault());
    }
}

package com.fixestiba.app.serivicios;

import com.fixestiba.app.dto.EstibaDTO;
import com.fixestiba.app.modelos.Estiba;
import com.fixestiba.app.repositorios.EstibaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstibaService {

    @Autowired
    private EstibaRepository estibaRepository; // Repositorio para acceso a la base de datos

    public Estiba guardarEstiba(EstibaDTO estibaDTO) {
        // Convertir el DTO en una entidad de base de datos
        Estiba estiba = new Estiba();
        estiba.setCantidadTablas(estibaDTO.getCantidadTablas());
        estiba.setCantidadTacos(estibaDTO.getCantidadTacos());
        estiba.setTipoEstiba(estibaDTO.getTipoEstiba());
        estiba.setFecha(estibaDTO.getFecha());

        // Guardar en la base de datos
        return estibaRepository.save(estiba);
    }
}

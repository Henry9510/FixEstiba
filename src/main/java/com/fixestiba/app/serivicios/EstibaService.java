package com.fixestiba.app.serivicios;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fixestiba.app.modelos.Estiba;
import com.fixestiba.app.repositorios.EstibaRepository;

@Service
public class EstibaService {

   @Autowired
    private EstibaRepository estibaRepository;

    public Estiba crearEstiba(Estiba estiba) {
        return estibaRepository.save(estiba);
    }

    public List<Estiba> obtenerTodasEstibas() {
        return estibaRepository.findAll();
    }

    public int obtenerTotalTablasPorTipo(String tipoEstiba) {
        return estibaRepository.sumTablasByTipoEstiba(tipoEstiba);
    }

    public int obtenerTotalTacosPorTipo(String tipoEstiba) {
        return estibaRepository.sumTacosByTipoEstiba(tipoEstiba);
    }

}

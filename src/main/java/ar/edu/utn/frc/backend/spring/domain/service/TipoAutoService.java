package ar.edu.utn.frc.backend.spring.domain.service;

import ar.edu.utn.frc.backend.spring.domain.model.TipoAuto;

import java.util.List;

public interface TipoAutoService {
    List<TipoAuto> findAll();

    TipoAuto findById(String id);

    TipoAuto save(TipoAuto tipoAuto);


}

package ar.edu.utn.frc.backend.spring.domain.service;

import ar.edu.utn.frc.backend.spring.domain.model.Modelo;

import java.util.List;

public interface ModeloService {
    Modelo getById(String id);

    List<Modelo> findAll();

    Modelo save(Modelo modelo);

    void delete(String id);
}

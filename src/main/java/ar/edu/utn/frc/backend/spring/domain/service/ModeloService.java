package ar.edu.utn.frc.backend.spring.domain.service;

import ar.edu.utn.frc.backend.spring.domain.model.Modelo;

import java.util.List;
import java.util.Optional;

public interface ModeloService {
    Modelo getById(String id);

    List<Modelo> findAll();

    Modelo save(Modelo modelo);

    void delete(String id);
}

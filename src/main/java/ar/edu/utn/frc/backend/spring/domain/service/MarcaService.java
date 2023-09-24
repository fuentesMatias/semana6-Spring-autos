package ar.edu.utn.frc.backend.spring.domain.service;

import ar.edu.utn.frc.backend.spring.domain.model.Marca;

import java.util.List;

public interface MarcaService {
    List<Marca> findAll();

    Marca findById(String id);

    Marca findByNombre(String nombre);

    Marca save(Marca marca);

    void delete(String id);
}

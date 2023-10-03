package ar.edu.utn.frc.backend.spring.domain.service;

import ar.edu.utn.frc.backend.spring.domain.model.Modelo;
import ar.edu.utn.frc.backend.spring.domain.repository.ModeloRepository;

import java.util.List;
import java.util.Optional;


public class DomainModeloService implements ModeloService{

    private final ModeloRepository modeloRepository;

    public DomainModeloService(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    @Override
    public Modelo getById(String id) {
        return modeloRepository.get(id).orElseThrow(()-> new RuntimeException("Modelo no encontrado"));
    }

    @Override
    public List<Modelo> findAll() {
        return modeloRepository.findAll();
    }

    @Override
    public Modelo save(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    @Override
    public void delete(String id) {

    }
}

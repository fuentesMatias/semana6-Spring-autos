package ar.edu.utn.frc.backend.spring.domain.service;

import ar.edu.utn.frc.backend.spring.domain.model.Marca;
import ar.edu.utn.frc.backend.spring.domain.repository.MarcaRepository;

import java.util.List;

public class DomainMarcaService implements MarcaService{
    private final MarcaRepository marcaRepository;

    public DomainMarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }
    @Override
    public List<Marca> findAll() {
        return marcaRepository.getAll();
    }

    @Override
    public Marca findById(String id) {
        return marcaRepository.getById(id);
    }

    @Override
    public Marca findByNombre(String nombre) {
        return marcaRepository.getByNombre(nombre);
    }

    @Override
    public Marca save(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public void delete(String id) {
        marcaRepository.delete(id);
    }
}

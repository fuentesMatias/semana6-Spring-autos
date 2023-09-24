package ar.edu.utn.frc.backend.spring.domain.service;

import ar.edu.utn.frc.backend.spring.domain.model.TipoAuto;
import ar.edu.utn.frc.backend.spring.domain.repository.TipoAutoRepository;

import java.util.List;

public class DomainTipoAutoService implements TipoAutoService{

    private final TipoAutoRepository tipoAutoRepository;

    public DomainTipoAutoService(TipoAutoRepository tipoAutoRepository) {
        this.tipoAutoRepository = tipoAutoRepository;
    }

    @Override
    public List<TipoAuto> findAll() {
        return tipoAutoRepository.getAll();
    }

    @Override
    public TipoAuto findById(String id) {
        return tipoAutoRepository.getById(id);
    }

    @Override
    public TipoAuto save(TipoAuto tipoAuto) {
        return tipoAutoRepository.save(tipoAuto);
    }
}

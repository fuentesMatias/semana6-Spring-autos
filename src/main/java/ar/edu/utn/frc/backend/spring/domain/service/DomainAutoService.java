package ar.edu.utn.frc.backend.spring.domain.service;

import ar.edu.utn.frc.backend.spring.domain.model.Auto;
import ar.edu.utn.frc.backend.spring.domain.model.Chasis;
import ar.edu.utn.frc.backend.spring.domain.model.Modelo;
import ar.edu.utn.frc.backend.spring.domain.repository.AutoRepository;

import java.util.List;


public class DomainAutoService implements AutoService{
    private final AutoRepository autoRepository;

    public DomainAutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @Override
    public String crearAuto(Modelo modelo) {
        //Creamos un auto con el modelo que nos dan por parametro
        Auto auxAuto = new Auto("1", modelo, new Chasis("2"));
        autoRepository.save(auxAuto);
        return auxAuto.toString();
    }

    @Override
    public Auto buscarAuto(String id) {
        return autoRepository.getById(id);
    }

    @Override
    public List<Auto> listarAutos() {
        return autoRepository.getAll();
    }
}

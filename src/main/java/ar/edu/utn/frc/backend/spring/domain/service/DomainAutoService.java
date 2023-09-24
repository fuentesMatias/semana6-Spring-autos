package ar.edu.utn.frc.backend.spring.domain.service;

import ar.edu.utn.frc.backend.spring.domain.model.Auto;
import ar.edu.utn.frc.backend.spring.domain.model.Chasis;
import ar.edu.utn.frc.backend.spring.domain.model.Modelo;
import ar.edu.utn.frc.backend.spring.domain.repository.AutoRepository;

import java.util.List;
import java.util.UUID;


public class DomainAutoService implements AutoService{
    private final AutoRepository autoRepository;

    public DomainAutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @Override
    public String crearAuto(Modelo modelo) { // el modelo pasado como parametro ya debe estar creado en la BD
        //Generamos un id para el auto y el chasis
        String autoId = UUID.randomUUID().toString();
        String chasisId = UUID.randomUUID().toString();


        //Creamos un auto con el modelo que nos dan por parametro
        Auto auxAuto = new Auto(autoId, modelo, new Chasis(chasisId));
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

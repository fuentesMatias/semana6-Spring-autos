package ar.edu.utn.frc.backend.spring.domain.service;

import ar.edu.utn.frc.backend.spring.application.request.ActualizarAutoRequest;
import ar.edu.utn.frc.backend.spring.domain.model.Auto;
import ar.edu.utn.frc.backend.spring.domain.model.Chasis;
import ar.edu.utn.frc.backend.spring.domain.model.Modelo;
import ar.edu.utn.frc.backend.spring.domain.repository.AutoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class DomainAutoService implements AutoService{
    private final AutoRepository autoRepository;
    private final ModeloService modeloService;

    public DomainAutoService(AutoRepository autoRepository, ModeloService domainModeloService) {
        this.autoRepository = autoRepository;
        this.modeloService = domainModeloService;
    }

    @Override
    public Auto crearAuto(String idModelo) {
        //Generamos un id para el nuevo auto.
        String autoId = UUID.randomUUID().toString();
        //String chasisId = UUID.randomUUID().toString();

        //Buscamos el modelo por id
        Modelo modelo = modeloService.getById(idModelo);

        //Creamos un auto con el modelo encontrado
        Auto auxAuto = new Auto(autoId, modelo ,Chasis.nuevo());

        return autoRepository.save(auxAuto);
    }

    @Override
    public Auto buscarAuto(String id) {
        return autoRepository.getById(id).orElseThrow(()-> new RuntimeException("Auto no encontrado"));
    }

    @Override
    public List<Auto> listarAutos() {
        return autoRepository.getAll();
    }

    @Override
    public Auto deleteAuto(String id) {
        return autoRepository.delete(id).orElseThrow(()-> new RuntimeException("Auto no encontrado"));
    }

    @Override
    public Auto updateAuto(String id, ActualizarAutoRequest autoRequest) {
        return autoRepository.update(id, autoRequest).orElseThrow(()-> new RuntimeException("Auto no encontrado"));
    }
}

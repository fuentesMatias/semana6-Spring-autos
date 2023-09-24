package ar.edu.utn.frc.backend.spring.application.controller;

import ar.edu.utn.frc.backend.spring.domain.model.Modelo;
import ar.edu.utn.frc.backend.spring.domain.repository.ModeloRepository;
import ar.edu.utn.frc.backend.spring.domain.service.ModeloService;
import ar.edu.utn.frc.backend.spring.infrastructure.repository.JpaModeloRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/modelo")
public class ModeloController {
    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping("/{id}")
    public Modelo modelo(@PathVariable("id")String id) {
        //si id es null tome por defecto 1
        if(id == null) {
            id = "1";
        }
        return modeloService.getById(id);
    }

    @GetMapping
    public List<Modelo> modelo() {
        return modeloService.findAll();
    }

    @PostMapping
    public Modelo save(@RequestBody Modelo modelo) {
        return modeloService.save(modelo);
    }


}
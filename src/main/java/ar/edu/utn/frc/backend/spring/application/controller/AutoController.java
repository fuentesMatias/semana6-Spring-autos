package ar.edu.utn.frc.backend.spring.application.controller;

import ar.edu.utn.frc.backend.spring.domain.model.Auto;
import ar.edu.utn.frc.backend.spring.domain.model.Modelo;
import ar.edu.utn.frc.backend.spring.domain.service.AutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/auto")
public class AutoController {
    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping("/{id}")
    public Auto autoId(@PathVariable("id")String id){
        return autoService.buscarAuto(id);
    }

    @PostMapping
    public String registrarAuto(@RequestBody Modelo modelo){
         return  autoService.crearAuto(modelo);
    }

    @GetMapping
    public List<Auto> listarAutos(){
        return autoService.listarAutos()
                .stream()
                .map(auto -> new Auto(auto.getId(), auto.getModelo(), auto.getChasis()))
                .collect(Collectors.toList());
    }
}

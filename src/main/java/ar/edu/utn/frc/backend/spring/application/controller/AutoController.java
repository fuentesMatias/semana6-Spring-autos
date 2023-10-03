package ar.edu.utn.frc.backend.spring.application.controller;

import ar.edu.utn.frc.backend.spring.application.request.CrearAutoRequest;
import ar.edu.utn.frc.backend.spring.domain.model.Auto;
import ar.edu.utn.frc.backend.spring.domain.model.Modelo;
import ar.edu.utn.frc.backend.spring.domain.service.AutoService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> autoId(@PathVariable("id")String id){
        try {
            return ResponseEntity.ok(autoService.buscarAuto(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> registrarAuto(@RequestBody CrearAutoRequest request){
        try {
             return ResponseEntity.ok(autoService.crearAuto(request.getModeloId()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping
    public List<Auto> listarAutos(){
        return autoService.listarAutos()
                .stream()
                .map(auto -> new Auto(auto.getId(), auto.getModelo(), auto.getChasis()))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuto(@PathVariable("id")String id){
        try {
            return ResponseEntity.ok(autoService.deleteAuto(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}

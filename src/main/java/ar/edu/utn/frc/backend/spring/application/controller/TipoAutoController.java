package ar.edu.utn.frc.backend.spring.application.controller;

import ar.edu.utn.frc.backend.spring.domain.model.TipoAuto;
import ar.edu.utn.frc.backend.spring.domain.service.TipoAutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"api/v1/tipoAuto"})
public class TipoAutoController {
    private final TipoAutoService tipoAutoService;

    public TipoAutoController(TipoAutoService tipoAutoService) {
        this.tipoAutoService = tipoAutoService;
    }

    @GetMapping
    public List<TipoAuto> tipoAuto() {
        return tipoAutoService.findAll()
                .stream()
                .map(tipoAuto -> new TipoAuto(tipoAuto.getId(), tipoAuto.getNombre()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TipoAuto tipoAuto(@PathVariable("id") String id) {
        return tipoAutoService.findById(id);
    }

    @PostMapping
    public TipoAuto save(@RequestBody TipoAuto tipoAuto) {
        return tipoAutoService.save(tipoAuto);
    }
}

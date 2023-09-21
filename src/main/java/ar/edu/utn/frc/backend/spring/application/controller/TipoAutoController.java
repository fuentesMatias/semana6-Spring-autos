package ar.edu.utn.frc.backend.spring.application.controller;

import ar.edu.utn.frc.backend.spring.domain.model.TipoAuto;
import ar.edu.utn.frc.backend.spring.domain.service.TipoAutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"api/v1"})
public class TipoAutoController {
    private final TipoAutoService tipoAutoService;

    public TipoAutoController(TipoAutoService tipoAutoService) {
        this.tipoAutoService = tipoAutoService;
    }

    @GetMapping("/tipoAuto")
    public List<TipoAuto> tipoAuto() {
        return tipoAutoService.findAll()
                .stream()
                .map(tipoAuto -> new TipoAuto(tipoAuto.getId(), tipoAuto.getNombre()))
                .collect(Collectors.toList());
    }
}

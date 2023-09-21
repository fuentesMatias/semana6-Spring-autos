package ar.edu.utn.frc.backend.spring.application.controller;

import ar.edu.utn.frc.backend.spring.application.response.MarcaResponse;
import ar.edu.utn.frc.backend.spring.domain.service.MarcaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/marcas")
public class MarcaController {
    private final MarcaService marcaService;

    public MarcaController (MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public List<MarcaResponse> marcas() {
        return marcaService.findAll()
                .stream()
                .map(marca -> new MarcaResponse(marca.getId(), marca.getNombre()))
                .collect(Collectors.toList());
    }

}

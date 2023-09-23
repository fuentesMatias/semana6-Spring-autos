package ar.edu.utn.frc.backend.spring.application.controller;

import ar.edu.utn.frc.backend.spring.application.response.MarcaResponse;
import ar.edu.utn.frc.backend.spring.domain.model.Marca;
import ar.edu.utn.frc.backend.spring.domain.service.MarcaService;
import ar.edu.utn.frc.backend.spring.infrastructure.repository.JpaMarcaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //get by id query param
    @GetMapping("/id")
    public Marca marcaById(@RequestParam Map<String, String> params) {
        return marcaService.findById(params.get("id"));
    }
    @GetMapping("/{id}")
    public Marca marcaById(@PathVariable String id) {
        return marcaService.findById(id);
    }

    //get by nombre
    @GetMapping("/nombre")
    public Marca marcaByNombre(@RequestParam Map<String, String> params) {
        return marcaService.findByNombre(params.get("nombre"));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Marca marca) {
        if (marcaService.findById(marca.getId()) != null) {
            // Si la marca ya existe, devuelve un error 400 (Bad Request)
            String errorMsg = "No se pudo registrar la marca. Ya existe una marca con el mismo ID.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg);
        }

        // Si la marca no existe, guárdala y devuelve un éxito 200 (OK)
        Marca savedMarca = marcaService.save(marca);
        return ResponseEntity.status(HttpStatus.OK).body(savedMarca);
    }
}

package ar.edu.utn.frc.backend.spring.domain.service;

import java.util.List;
import java.util.Optional;

import ar.edu.utn.frc.backend.spring.application.request.ActualizarAutoRequest;
import ar.edu.utn.frc.backend.spring.application.request.CrearAutoRequest;
import ar.edu.utn.frc.backend.spring.domain.model.Auto;
import ar.edu.utn.frc.backend.spring.domain.model.Modelo;

public interface AutoService {
	Auto crearAuto(String idModelo);

	Auto buscarAuto(String id);

	List<Auto> listarAutos();

	Auto deleteAuto(String id);

	Auto updateAuto(String id, ActualizarAutoRequest autoRequest);
}

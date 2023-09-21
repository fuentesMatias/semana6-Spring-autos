package ar.edu.utn.frc.backend.spring.domain.repository;

import ar.edu.utn.frc.backend.spring.domain.model.Modelo;

public interface ModeloRepository {
	Modelo get(String id);
}

package ar.edu.utn.frc.backend.spring.domain.repository;

import java.util.List;
import java.util.Optional;

import ar.edu.utn.frc.backend.spring.application.request.ActualizarAutoRequest;
import ar.edu.utn.frc.backend.spring.domain.model.Auto;

public interface AutoRepository {
	List<Auto> getAll();

	Auto save(Auto auto);

	Optional<Auto> getById(String id);


	Optional<Auto> delete(String id);

	Optional<Auto> update(String id, ActualizarAutoRequest autoRequest);
}

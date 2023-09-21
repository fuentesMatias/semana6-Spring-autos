package ar.edu.utn.frc.backend.spring.domain.repository;

import java.util.List;

import ar.edu.utn.frc.backend.spring.domain.model.Auto;

public interface AutoRepository {
	List<Auto> getAll();

	void save(Auto auto);

	Auto getById(String id);
}

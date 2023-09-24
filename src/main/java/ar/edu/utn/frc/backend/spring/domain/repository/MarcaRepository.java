package ar.edu.utn.frc.backend.spring.domain.repository;

import java.util.List;

import ar.edu.utn.frc.backend.spring.domain.model.Marca;

public interface MarcaRepository {
	List<Marca> getAll();

	Marca getById(String id);

	Marca save(Marca marca);

	void delete(String id);

	Marca update(Marca marca);

	Marca getByNombre(String nombre);



}

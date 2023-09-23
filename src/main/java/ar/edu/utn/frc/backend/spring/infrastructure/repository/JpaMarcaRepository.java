package ar.edu.utn.frc.backend.spring.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.utn.frc.backend.spring.domain.model.Marca;
import ar.edu.utn.frc.backend.spring.domain.repository.MarcaRepository;
import ar.edu.utn.frc.backend.spring.infrastructure.dao.JpaMarcaDao;
import ar.edu.utn.frc.backend.spring.infrastructure.entity.MarcaEntity;

@Component
public class JpaMarcaRepository implements MarcaRepository {

	private final JpaMarcaDao marcaDao;

	public JpaMarcaRepository(JpaMarcaDao marcaDao) {
		this.marcaDao = marcaDao;
	}

	@Override public List<Marca> getAll() {
		return marcaDao.findAll()
			.stream()
			.map(MarcaEntity::toMarca)
			.toList();
	}

	@Override
	public Marca getById(String id) {
		return marcaDao.findById(id)
			.map(MarcaEntity::toMarca)
			.orElse(null);
	}

	@Override
	public Marca save(Marca marca) {
		return marcaDao.save(MarcaEntity.from(marca))
			.toMarca();
	}

	@Override
	public Marca delete(String id) {
		return null;
	}

	@Override
	public Marca update(Marca marca) {
		return null;
	}

	@Override
	public Marca getByNombre(String nombre) {
		return marcaDao.findAll()
				.stream()
				.filter(marcaEntity -> marcaEntity.getNombre().equalsIgnoreCase(nombre))
				.map(MarcaEntity::toMarca)
				.findFirst()
				.orElse(null);
	}
}

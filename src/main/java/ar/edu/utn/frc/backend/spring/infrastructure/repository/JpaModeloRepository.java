package ar.edu.utn.frc.backend.spring.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.utn.frc.backend.spring.domain.model.Modelo;
import ar.edu.utn.frc.backend.spring.domain.repository.ModeloRepository;
import ar.edu.utn.frc.backend.spring.infrastructure.dao.JpaModeloDao;
import ar.edu.utn.frc.backend.spring.infrastructure.entity.ModeloEntity;

import java.util.List;
import java.util.Optional;

@Component
public class JpaModeloRepository implements ModeloRepository {
	@Autowired
	private JpaModeloDao modeloDao;

	//@Autowired
	public JpaModeloRepository(JpaModeloDao modeloDao) {
		this.modeloDao = modeloDao;
	}

	@Override
	public Optional<Modelo> get(String id) {
		return modeloDao.findById(id)
				.map(ModeloEntity::toModelo);
	}

	@Override
	public List<Modelo> findAll() {
		return modeloDao.findAll()
				.stream()
				.map(ModeloEntity::toModelo)
				.toList();
	}

	@Override
	public Modelo save(Modelo modelo) {
		return modeloDao.save(ModeloEntity.from(modelo)).toModelo();
	}

	@Override
	public void delete(String id) {

	}

	@Override
	public void update(Modelo modelo) {

	}
}

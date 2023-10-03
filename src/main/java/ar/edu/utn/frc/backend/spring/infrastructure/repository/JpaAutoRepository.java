package ar.edu.utn.frc.backend.spring.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ar.edu.utn.frc.backend.spring.application.request.ActualizarAutoRequest;
import org.springframework.stereotype.Component;

import ar.edu.utn.frc.backend.spring.domain.model.Auto;
import ar.edu.utn.frc.backend.spring.domain.repository.AutoRepository;
import ar.edu.utn.frc.backend.spring.infrastructure.dao.JpaAutoDao;
import ar.edu.utn.frc.backend.spring.infrastructure.entity.AutoEntity;
import ar.edu.utn.frc.backend.spring.infrastructure.entity.ModeloEntity;

@Component
public class JpaAutoRepository implements AutoRepository {
	private final JpaAutoDao autoDao;

	public JpaAutoRepository(JpaAutoDao autoDao) {
		this.autoDao = autoDao;
	}

	@Override public List<Auto> getAll() {
		return autoDao.findAll()
			.stream()
			.map(AutoEntity::toAuto)
			.collect(Collectors.toList());
	}

	@Override public Auto save(Auto auto) {
		autoDao.save(new AutoEntity(
			auto.getId(),
			auto.getChasis().getNumero(),
			ModeloEntity.from(auto.getModelo())
		));
		return auto;
	}

	@Override
	public Optional<Auto> getById(String id) {
		return autoDao.findById(id)
				.map(AutoEntity::toAuto);
	}

	@Override
	public Optional<Auto> delete(String id) {
		autoDao.findById(id).ifPresent(autoDao::delete);
		return autoDao.findById(id)
				.map(AutoEntity::toAuto);
	}

	@Override
	public Optional<Auto> update(String id, ActualizarAutoRequest autoRequest) {
		return Optional.empty();
	}
}

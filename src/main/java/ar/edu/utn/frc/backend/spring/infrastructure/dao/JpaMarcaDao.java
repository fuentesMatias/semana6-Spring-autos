package ar.edu.utn.frc.backend.spring.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frc.backend.spring.infrastructure.entity.MarcaEntity;


@Repository
// @Repository es una anotación de Spring que se utiliza para indicar que esta interfaz
// es un componente de repositorio.
// Los componentes de repositorio son responsables de interactuar con la base de datos.
// Spring Data JPA utiliza esta anotación para escanear y
// crear automáticamente implementaciones de repositorios en tiempo de ejecución.
public interface JpaMarcaDao extends JpaRepository<MarcaEntity, String> { }

// Esta es la definición de una interfaz de Java llamada JpaMarcaDao. Esta interfaz extiende la interfaz
// JpaRepository de Spring Data JPA.

// JpaRepository es una interfaz proporcionada por Spring Data JPA que simplifica
// la creación de repositorios de datos. Los repositorios
// de datos son componentes que se utilizan para realizar operaciones
// CRUD (Crear, Leer, Actualizar y Borrar) en una base de datos.

// JpaRepository toma dos parámetros genéricos:
// el tipo de entidad (MarcaEntity en este caso) y
// el tipo de la clave primaria de la entidad (String en este caso).


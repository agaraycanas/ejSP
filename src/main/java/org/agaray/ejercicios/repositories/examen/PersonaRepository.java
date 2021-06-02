package org.agaray.ejercicios.repositories.examen;

import java.util.List;

import org.agaray.ejercicios.entities.examen.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
	public List<Persona> findAllBySexo(String sexo);
}

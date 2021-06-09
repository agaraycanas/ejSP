package org.agaray.ejercicios.repositories.examen;

import org.agaray.ejercicios.entities.examen.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

}

package org.agaray.ejercicios.repositories.t4.ej02;

import org.agaray.ejercicios.entities.t4.ej02.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
}

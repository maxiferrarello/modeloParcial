package com.miModeloParcial.modeloParcial.Estantes.Repositorio;

import com.miModeloParcial.modeloParcial.Estantes.EntidadEstantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEstantes extends JpaRepository<EntidadEstantes,Long> {
}

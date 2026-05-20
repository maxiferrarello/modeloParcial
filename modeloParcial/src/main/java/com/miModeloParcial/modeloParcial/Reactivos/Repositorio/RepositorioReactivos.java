package com.miModeloParcial.modeloParcial.Reactivos.Repositorio;

import com.miModeloParcial.modeloParcial.Reactivos.Model.EntidadReactivos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioReactivos extends JpaRepository<EntidadReactivos, Long> {

    List<EntidadReactivos> findByName(String name);

    List<EntidadReactivos> findByNivelPeligro(Long nivelPeligro);

    List<EntidadReactivos> findByEsProcursorQuimico(boolean esProcursorQuimico);
}

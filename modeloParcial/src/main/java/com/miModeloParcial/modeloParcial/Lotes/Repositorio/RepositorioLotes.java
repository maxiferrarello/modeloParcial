package com.miModeloParcial.modeloParcial.Lotes.Repositorio;

import com.miModeloParcial.modeloParcial.Lotes.Model.EntidadLotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioLotes extends JpaRepository <EntidadLotes,Long>{
}

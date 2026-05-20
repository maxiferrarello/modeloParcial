package com.miModeloParcial.modeloParcial.Lotes.ServicioLotes;

import com.miModeloParcial.modeloParcial.Lotes.Dominio.DTO.LotesDTO;

import java.util.List;

public interface IServicioLotes {

    /// CRUD OBLIGATORIOS
    ///
    LotesDTO guardar (LotesDTO lotesDTO);
    void borrar (Long id);
    LotesDTO buscarPorId(Long id);
    LotesDTO actualizar(Long id, LotesDTO lotesDTO);
    List<LotesDTO> buscarTodos();

}

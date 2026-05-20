package com.miModeloParcial.modeloParcial.Reactivos.Servicio;

import com.miModeloParcial.modeloParcial.Reactivos.Dominio.DTO.ReactivoDTO;

import java.util.List;

public interface IServicioReactivos {

    /// crud obligatorios
    ReactivoDTO guardar(ReactivoDTO reactivoDTO);
    void borrar (Long id);
    ReactivoDTO buscarPorId(Long id);
    ReactivoDTO actualizar (Long id, ReactivoDTO reactivoDTO);
    List<ReactivoDTO> buscarTodos();

    /// Agregados para resolver una consulta.
    List<ReactivoDTO> buscarPorNombre(String name);
    List<ReactivoDTO> buscarPorNivelPeligro(Long nivelPeligro);
    List<ReactivoDTO> buscarPorProcursorQuimico(boolean esProcursorQuimico);
}



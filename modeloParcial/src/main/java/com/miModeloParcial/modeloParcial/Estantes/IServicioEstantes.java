package com.miModeloParcial.modeloParcial.Estantes;

import com.miModeloParcial.modeloParcial.Estantes.Dominio.DTO.EstanteDTO;

import java.util.List;

public interface IServicioEstantes {
    /// crud obligatorios
    public EstanteDTO guardar (EstanteDTO estanteDTO);
    public void borrar(Long id);
    public EstanteDTO actualizar (Long id,EstanteDTO estanteDTO);
    public List<EstanteDTO> buscarTodos ();
}

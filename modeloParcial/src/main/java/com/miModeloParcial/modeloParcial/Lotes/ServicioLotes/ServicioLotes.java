package com.miModeloParcial.modeloParcial.Lotes.ServicioLotes;

import com.miModeloParcial.modeloParcial.Lotes.Dominio.DTO.LotesDTO;
import com.miModeloParcial.modeloParcial.Lotes.Dominio.Mappers.LotesMapper;
import com.miModeloParcial.modeloParcial.Lotes.Model.EntidadLotes;
import com.miModeloParcial.modeloParcial.Lotes.Repositorio.RepositorioLotes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ServicioLotes implements IServicioLotes{

    private final RepositorioLotes repositorioLotes;
    private final LotesMapper lotesMapper;


    @Override
    public LotesDTO guardar(LotesDTO lotesDTO) {
        EntidadLotes guardado = (EntidadLotes) repositorioLotes.save(lotesMapper.toEntity(lotesDTO));

        return lotesMapper.toDTO(guardado);
    }

    @Override
    public void borrar(Long id) {

    }

    @Override
    public LotesDTO buscarPorId(Long id) {
        return null;
    }

    @Override
    public LotesDTO actualizar(Long id, LotesDTO lotesDTO) {
        return null;
    }

    @Override
    public List<LotesDTO> buscarTodos() {
        return List.of();
    }
}

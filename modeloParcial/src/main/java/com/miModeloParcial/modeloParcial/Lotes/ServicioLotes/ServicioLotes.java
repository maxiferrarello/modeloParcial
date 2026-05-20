package com.miModeloParcial.modeloParcial.Lotes.ServicioLotes;

import com.miModeloParcial.modeloParcial.Lotes.Dominio.DTO.LotesDTO;
import com.miModeloParcial.modeloParcial.Lotes.Dominio.Mappers.LotesMapper;
import com.miModeloParcial.modeloParcial.Lotes.Exception.LoteNoEncontradoException;
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
        repositorioLotes.findById(id).ifPresent(repositorioLotes::delete);
    }


    @Override
    public LotesDTO buscarPorId(Long id) {
        return repositorioLotes.findById(id)
                .map(lotesMapper::toDTO)
                .orElseThrow(()-> new LoteNoEncontradoException("No se encontro el lote con id " + id));
    }

    @Override
    public LotesDTO actualizar(Long id, LotesDTO lotesDTO) {
        EntidadLotes lot = repositorioLotes.findById(id)
                .orElseThrow();
        lot.setCantidad_kg(lotesDTO.getCantidad_kg());
        lot.setNro_lote(lotesDTO.getNro_lote());
        lot.setFecha_recepcion(lotesDTO.getFecha_recepcion());
        lot.setFecha_vencimiento(lotesDTO.getFecha_vencimiento());

        EntidadLotes actualizado = repositorioLotes.save(lot);
        return lotesMapper.toDTO(actualizado);
    }


    @Override
    public List<LotesDTO> buscarTodos() {
        return repositorioLotes.findAll()
                .stream()
                .map(lotesMapper::toDTO)
                .toList();
    }
}

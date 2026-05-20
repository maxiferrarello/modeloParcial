package com.miModeloParcial.modeloParcial.Estantes;

import com.miModeloParcial.modeloParcial.Estantes.Dominio.DTO.EstanteDTO;
import com.miModeloParcial.modeloParcial.Estantes.Dominio.Mappers.EstanteMapper;
import com.miModeloParcial.modeloParcial.Estantes.Repositorio.RepositorioEstantes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioEstantes implements IServicioEstantes{

    private final RepositorioEstantes repositorioEstantes;
    private final EstanteMapper estanteMapper;


    @Override
    public EstanteDTO guardar(EstanteDTO estanteDTO) {

        EntidadEstantes guardado = repositorioEstantes.save(estanteMapper.toEntity(estanteDTO));

        return estanteMapper.toDto(guardado);
    }

    @Override
    public void borrar(Long id) {
        repositorioEstantes.findById(id).ifPresent(repositorioEstantes::delete);
    }

    @Override
    public EstanteDTO actualizar(Long id, EstanteDTO estanteDTO) {
        EntidadEstantes est = repositorioEstantes.findById(id)
                .orElseThrow();
        est.setCodigoAlmacen(estanteDTO.getCodigoAlmacen());
        est.setCapacidadMaxKg(estanteDTO.getCapacidadMaxKg());
        est.setRiesgoLimite(estanteDTO.getRiesgoLimite());

        EntidadEstantes actualizado = repositorioEstantes.save(est);

        return estanteMapper.toDto(actualizado);
    }

    @Override
    public List<EstanteDTO> buscarTodos() {

        return repositorioEstantes.findAll()
                .stream()
                .map(estanteMapper::toDto)
                .toList();
    }
}

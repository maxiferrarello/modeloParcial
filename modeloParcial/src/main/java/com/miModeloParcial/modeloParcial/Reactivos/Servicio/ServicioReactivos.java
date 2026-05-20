package com.miModeloParcial.modeloParcial.Reactivos.Servicio;

import com.miModeloParcial.modeloParcial.Reactivos.Dominio.DTO.ReactivoDTO;
import com.miModeloParcial.modeloParcial.Reactivos.Dominio.Mappers.ReactivoMapper;
import com.miModeloParcial.modeloParcial.Reactivos.Exception.ReactivoNoEncontradoException;
import com.miModeloParcial.modeloParcial.Reactivos.Model.EntidadReactivos;
import com.miModeloParcial.modeloParcial.Reactivos.Repositorio.RepositorioReactivos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioReactivos implements IServicioReactivos {

    private final RepositorioReactivos repositorioReactivos;
    private final ReactivoMapper reactivoMapper;


    @Override
    public ReactivoDTO guardar(ReactivoDTO reactivoDTO) {

        EntidadReactivos guardado = repositorioReactivos.save(reactivoMapper.toEntity(reactivoDTO)); // el .save retorna lo que le llega por parametro. le llega una entidad, devuelve esa entidad guardada
        return reactivoMapper.toDTO(guardado);
    }

    @Override
    public void borrar(Long id) {

        this.repositorioReactivos.findById(id).ifPresent(repositorioReactivos::delete);// “dado un reactivo, ejecutá delete sobre ese reactivo”.
        // this.repositorioReactivos.findById(id).ifPresent(reactivos -> repositorioReactivos.delete(reactivos));// “dado un reactivo, ejecutá delete sobre ese reactivo”.
    }

    @Override
    public ReactivoDTO buscarPorId(Long id) {
        return repositorioReactivos.findById(id)
                .map(reactivoMapper::toDTO) //“si hay un reactivo con ese id, convertímelo a DTO”. equivalente a... reactivo -> reactivoMapper.toDTO(reactivo)
                .orElseThrow(()-> new ReactivoNoEncontradoException("No se encontro el reactivo con ID" + id));
    }

    @Override
    public ReactivoDTO actualizar(Long id, ReactivoDTO reactivoDTO) {

        EntidadReactivos reac = repositorioReactivos.findById(id)
                .orElseThrow();
        reac.setName(reactivoDTO.getName());
        reac.setNivelPeligro(reactivoDTO.getNivelPeligro());
        reac.setEsProcursorQuimico(reactivoDTO.isEsProcursorQuimico());

        EntidadReactivos actualizado = repositorioReactivos.save(reac);

        return reactivoMapper.toDTO(actualizado);
    }

    @Override
    public List<ReactivoDTO> buscarTodos() {
        return repositorioReactivos.findAll().stream().map(reactivoMapper::toDTO).toList();
    }

    @Override
    public List<ReactivoDTO> buscarPorNombre(String name) {
        return repositorioReactivos.findByName(name)
                .stream()
                .map(reactivoMapper::toDTO)
                .toList();
    }

    @Override
    public List<ReactivoDTO> buscarPorNivelPeligro(Long nivelPeligro) {
        return repositorioReactivos.findByNivelPeligro(nivelPeligro)
                .stream()
                .map(reactivoMapper::toDTO)
                .toList();
    }


    @Override
    public List<ReactivoDTO> buscarPorProcursorQuimico(boolean esProcursorQuimico) {
        return repositorioReactivos.findByEsProcursorQuimico(esProcursorQuimico)
                .stream()
                .map(reactivoMapper::toDTO)
                .toList();
    }


}

//findByName → repository
//buscarPorNombre → interface service + implementation service



//Controller
//↓
//IServicioReactivos
//↓
//ServicioReactivos
//↓
//RepositorioReactivos
//↓
//Base de datos
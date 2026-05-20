package com.miModeloParcial.modeloParcial.Reactivos.Dominio.Mappers;

import com.miModeloParcial.modeloParcial.Reactivos.Dominio.DTO.ReactivoDTO;
import com.miModeloParcial.modeloParcial.Reactivos.Model.EntidadReactivos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReactivoMapper {

    ReactivoDTO toDTO (EntidadReactivos entidadReactivos);
    EntidadReactivos toEntity (ReactivoDTO reactivoDTO);
}

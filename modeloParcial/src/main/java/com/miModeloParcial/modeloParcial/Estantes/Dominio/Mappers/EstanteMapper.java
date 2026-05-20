package com.miModeloParcial.modeloParcial.Estantes.Dominio.Mappers;

import com.miModeloParcial.modeloParcial.Estantes.Dominio.DTO.EstanteDTO;
import com.miModeloParcial.modeloParcial.Estantes.Model.EntidadEstantes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstanteMapper {

    EstanteDTO toDto (EntidadEstantes entidadEstantes);
    EntidadEstantes toEntity (EstanteDTO estanteDTO);

}

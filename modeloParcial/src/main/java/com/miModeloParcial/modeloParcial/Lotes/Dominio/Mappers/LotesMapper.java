package com.miModeloParcial.modeloParcial.Lotes.Dominio.Mappers;

import com.miModeloParcial.modeloParcial.Lotes.Dominio.DTO.LotesDTO;
import com.miModeloParcial.modeloParcial.Lotes.Model.EntidadLotes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LotesMapper {

    EntidadLotes toEntity (LotesDTO lotesDTO);
    LotesDTO toDTO (EntidadLotes entidadLotes);

}

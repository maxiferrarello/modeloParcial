package com.miModeloParcial.modeloParcial.Estantes.Dominio.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstanteDTO {

    @NotBlank
    private String codigoAlmacen;

    @NotNull
    @Positive
    private BigDecimal capacidadMaxKg;

    @NotNull
    @Min(0)
    @Max(10)
    private Long riesgoLimite;



}

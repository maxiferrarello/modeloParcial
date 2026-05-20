package com.miModeloParcial.modeloParcial.Lotes.Dominio.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LotesDTO {

    @NotBlank
    private String nro_lote;

    private LocalDate fecha_recepcion;

    private LocalDate fecha_vencimiento;

    @Positive
    @NotNull
    private BigDecimal cantidad_kg;

    @Positive
    @NotNull
    private Long id_reactivo;

    @Positive
    @NotNull
    private Long id_estante;
}

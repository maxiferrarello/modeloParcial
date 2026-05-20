package com.miModeloParcial.modeloParcial.Reactivos.Dominio.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReactivoDTO {

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    @Min(1)
    @Max(10)
    private Long nivelPeligro;

    private boolean esProcursorQuimico; // nunca puede ser nulo entonces no ponemos @notNull

}

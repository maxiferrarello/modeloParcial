package com.miModeloParcial.modeloParcial.Estantes;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estantes")
public class EntidadEstantes {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "codigo_almacen",nullable = false,length = 50)
    private String codigoAlmacen;

    @NotNull
    @Positive
    @Column(name = "capacidad_max_kg",nullable = false,precision = 10,scale = 2)
    private BigDecimal capacidadMaxKg;


    @NotNull
    @Min(1)
    @Max(10)
    @Column(name = "riesgo_limite",nullable = false)
    private Long riesgoLimite;


}

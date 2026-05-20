package com.miModeloParcial.modeloParcial.Lotes;

import com.miModeloParcial.modeloParcial.Estantes.Model.EntidadEstantes;
import com.miModeloParcial.modeloParcial.Reactivos.Model.EntidadReactivos;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "lotes")
public class EntidadLotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nro_lote",nullable = false)
    private String nro_lote;

    @Column(name = "fecha_recepcion",nullable = false)
    private LocalDate fecha_recepcion;

    @Column(name = "fecha_vencimiento",nullable = false)
    private LocalDate fecha_vencimiento;

    @Column(name = "cantidad_kg",nullable = false)
    private BigDecimal cantidad_kg;

    /// RELACIONES ENTRE TABLAS.
    @ManyToOne
    @JoinColumn(name = "id_reactivo")
    private EntidadReactivos entidadReactivos;

    @ManyToOne
    @JoinColumn(name = "id_estante")
    private EntidadEstantes entidadEstantes;








}

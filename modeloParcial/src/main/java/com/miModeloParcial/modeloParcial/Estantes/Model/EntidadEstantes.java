package com.miModeloParcial.modeloParcial.Estantes.Model;

import com.miModeloParcial.modeloParcial.Lotes.Model.EntidadLotes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

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

    @Column(name = "codigo_almacen",nullable = false,length = 50)
    private String codigoAlmacen;

    @Column(name = "capacidad_max_kg",nullable = false,precision = 10,scale = 2)
    private BigDecimal capacidadMaxKg;

    @Column(name = "riesgo_limite",nullable = false)
    private Long riesgoLimite;

    @OneToMany(mappedBy = "estantes")
    private List<EntidadLotes> lotes;
}

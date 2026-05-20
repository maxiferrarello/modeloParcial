package com.miModeloParcial.modeloParcial.Reactivos.Model;

import com.miModeloParcial.modeloParcial.Lotes.EntidadLotes;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reactivos")
public class EntidadReactivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false,length = 50) // validaciones en la BD
    private String name;

    @Column(name = "nivel_peligro",nullable = false)
    private Long nivelPeligro;

    @Column(name = "es_procursor_quimico",nullable = false)
    private boolean esProcursorQuimico;

    @Column(name = "activo",nullable = false)
    private boolean activo;


    @OneToMany(mappedBy = "reactivos")
    private List<EntidadLotes> lotes;




}

package com.miModeloParcial.modeloParcial.Lotes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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






}

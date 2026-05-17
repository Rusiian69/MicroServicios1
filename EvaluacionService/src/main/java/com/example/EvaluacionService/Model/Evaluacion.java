package com.example.EvaluacionService.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "evaluacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idEmpresa;

    @Column(nullable = false)
    private Long idPostulante;

    @Column(nullable = false)
    private Integer puntaje;

    @Column(nullable = false)
    private String comentarios;
}
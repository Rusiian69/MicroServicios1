package com.example.EvaluacionService.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


    @Entity
    @Table(name = "resultado_evaluacion")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class ResultadoEvaluacion {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private Long idEvaluacion;

        @Column(nullable = false)
        private Long idPostulante;

        @Column(nullable = false)
        private Integer puntaje;

        @Column(nullable = false)
        private String estado; // "APROBADO" o "REPROBADO"

        @Column(nullable = false)
        private Integer intentos;

        @Column(nullable = false)
        private LocalDateTime fechaRealizacion;
        }
package com.example.postulacionservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "postulaciones",

        uniqueConstraints = @UniqueConstraint(
                name = "uk_postulante_oferta",
                columnNames = {"postulanteId", "ofertaId"}
        )
)
public class Postulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postulanteId;

    @Column(nullable = false)
    private Long ofertaId;

    @Column(nullable = false, length = 20)
    private String estado;

    @Column(nullable = false, length = 30)
    private String fechaPostulacion;
}

package com.JOB_GESTION.OFERTA.MODELO;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Table(name = "Ofertas de trabajo")
@AllArgsConstructor
@NoArgsConstructor
public class OFERTA {

    @Id
    private Long id;

    
    private String titulo;

    private String descripcion;

    private String requisito;

    private String empresaId;


}

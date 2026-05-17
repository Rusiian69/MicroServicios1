package com.JOB_GESTION.OFERTA.MODELO.dto;

import jakarta.annotation.sql.DataSourceDefinition;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoResponseOferta {

    
    private Long id;
    
    private String titulo;

    private String descripcion;

    private String requisito;

    private String empresanombre;

}

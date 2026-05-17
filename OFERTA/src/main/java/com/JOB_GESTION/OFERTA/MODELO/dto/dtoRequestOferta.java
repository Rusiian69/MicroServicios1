package com.JOB_GESTION.OFERTA.MODELO.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoRequestOferta {


    @NotBlank(message = "El titulo no puede estar vacio")@Column(length = 35)
    private String titulo;


    @NotBlank(message = "La descripcion no puede estar vacia")@Column(length = 195 )
    private String descripcion;

    @NotBlank(message = "Los requisitos no pueden estar vacios")@Column(length = 240)
    private String requisito;

    private String empresaId;
   
}

package com.example.postulacionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostulacionResponseDTO {

    private Long id;
    private Long postulanteId;
    private Long ofertaId;
    private String estado;
    private String fechaPostulacion;
}

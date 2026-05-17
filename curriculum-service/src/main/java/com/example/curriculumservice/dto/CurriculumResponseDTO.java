package com.example.curriculumservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumResponseDTO {

    private Long id;
    private Long postulanteId;
    private String nombreArchivo;
    private String urlArchivo;
    private String fechaSubida;
}

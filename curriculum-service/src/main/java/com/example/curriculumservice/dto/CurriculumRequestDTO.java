package com.example.curriculumservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumRequestDTO {

    @NotNull(message = "El campo postulanteId es obligatorio")
    private Long postulanteId;

    @NotBlank(message = "El campo nombreArchivo es obligatorio")
    private String nombreArchivo;

    @NotBlank(message = "El campo urlArchivo es obligatorio")
    private String urlArchivo;
}

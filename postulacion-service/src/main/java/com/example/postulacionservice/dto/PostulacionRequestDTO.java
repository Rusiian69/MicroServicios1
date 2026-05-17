package com.example.postulacionservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostulacionRequestDTO {

    @NotNull(message = "El campo postulanteId es obligatorio")
    private Long postulanteId;

    @NotNull(message = "El campo ofertaId es obligatorio")
    private Long ofertaId;

    private String estado;
}

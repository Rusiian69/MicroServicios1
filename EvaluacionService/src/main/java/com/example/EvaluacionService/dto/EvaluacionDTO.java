package com.example.EvaluacionService.dto;



import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EvaluacionDTO {

    @NotNull(message = "idEmpresa obligatorio")
    private Long idEmpresa;

    @NotNull(message = "idPostulante obligatorio")
    private Long idPostulante;

    @NotNull(message = "Puntaje obligatorio")
    @Min(value = 1, message = "Puntaje mínimo es 1")
    @Max(value = 5, message = "Puntaje máximo es 5")
    private Integer puntaje;

    @NotBlank(message = "Comentarios obligatorio")
    private String comentarios;
}

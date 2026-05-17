package com.example.EvaluacionService.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ResultadoEvaluacionDTO {

    @NotNull(message = "idEvaluacion obligatorio")
    private Long idEvaluacion;

    @NotNull(message = "idPostulante obligatorio")
    private Long idPostulante;

    @NotNull(message = "Puntaje obligatorio")
    @Min(value = 0, message = "Puntaje mínimo es 0")
    @Max(value = 100, message = "Puntaje máximo es 100")
    private Integer puntaje;

    @NotBlank(message = "Estado obligatorio")
    private String estado; // "APROBADO" o "REPROBADO"

    @NotNull(message = "Intentos obligatorio")
    @Min(value = 1, message = "Mínimo 1 intento")
    private Integer intentos;

    @NotNull(message = "Fecha obligatoria")
    private LocalDateTime fechaRealizacion;
}
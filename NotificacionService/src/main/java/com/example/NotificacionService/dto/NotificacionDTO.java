package com.example.NotificacionService.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificacionDTO {

    @NotNull(message = "idUsuario obligatorio")
    private Long idUsuario;

    @NotBlank(message = "El mensaje no puede estar vacío")
    private String mensaje;

    @NotNull(message = "El campo leido es obligatorio")
    private Boolean leido;
}

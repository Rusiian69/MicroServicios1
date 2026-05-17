package com.example.CategoriaService.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoriaDTO {

    @NotBlank(message = "El nombre de la categoría no puede estar vacío")
    private String nombre;
}
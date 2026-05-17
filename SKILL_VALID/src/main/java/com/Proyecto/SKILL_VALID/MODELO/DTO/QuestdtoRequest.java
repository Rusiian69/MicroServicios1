package com.Proyecto.SKILL_VALID.MODELO.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestdtoRequest {

    @NotBlank(message = "La pregunta no puede estar vacia")
    @Column(length=65)
    private String pregunta;

    @NotNull(message = "La IdEmpresa es obligatoria")
    private String empresaId;

    @NotNull(message = "La categoria_questId es obligatorio")
    private Long categoria_questId;

    private Long answerSkill_Id;
    
    
    
}

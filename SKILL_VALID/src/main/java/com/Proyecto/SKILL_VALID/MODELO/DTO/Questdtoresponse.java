package com.Proyecto.SKILL_VALID.MODELO.DTO;

import lombok.Data;



import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questdtoresponse {

    private Long id;

    private String pregunta;

    private String empresanombre;

    private String categoria_questnombre_categoria;

    private String answer_skill_respuesta;
    
}

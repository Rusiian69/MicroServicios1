package com.Proyecto.SKILL_VALID.MODELO.DTO;

import com.Proyecto.SKILL_VALID.MODELO.QuestSkill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDtoRequest {

    private String nombreUsuario;

    private int respuestaUser;

    private Long questSkillId;
}

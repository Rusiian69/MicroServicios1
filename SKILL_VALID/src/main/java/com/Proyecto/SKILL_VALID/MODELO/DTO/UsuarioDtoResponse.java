package com.Proyecto.SKILL_VALID.MODELO.DTO;

import java.util.*;
import com.Proyecto.SKILL_VALID.MODELO.QuestSkill;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDtoResponse {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID userId;

    private String nombreUsuario;

    private int respuestaUser;
    
    private String questSkillNombre;
}

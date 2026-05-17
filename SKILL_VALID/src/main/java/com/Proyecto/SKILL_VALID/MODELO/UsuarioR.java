package com.Proyecto.SKILL_VALID.MODELO;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Respuesta de usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioR {
    @Id 
    private UUID userId;

    private String nombreUsuario;

    private int respuestaUser;
    
    private QuestSkill questSkill;
}

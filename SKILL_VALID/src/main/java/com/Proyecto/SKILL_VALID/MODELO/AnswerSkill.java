package com.Proyecto.SKILL_VALID.MODELO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Respuesta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerSkill {

    @Id @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Este campo no puede estar vacio")
    private String respuesta;

    @Column(unique = true)
    private UUID idUser;

    private String respuestaUser; 

    private QuestSkill questSkill;
    
}
package com.Proyecto.SKILL_VALID.MODELO;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name =  "preguntas skill")
public class QuestSkill {

    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;

    @NotBlank(message = "No puede dejar este caracter en blanco")
    private String pregunta;
    
    @Column(unique = true)
    private String empresaId;

    private Categoria_Quest categoria_Quest;

    private AnswerSkill answerSkill;

}
package com.Proyecto.SKILL_VALID.REPOSITORY;

import com.Proyecto.SKILL_VALID.MODELO.QuestSkill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryQK extends JpaRepository<QuestSkill, Long> {


    List<QuestSkill> findByPreguntaContainingIgnoreCase(String pregunta);

    List<QuestSkill> findByEmpresaNombreContainigIgnoreCase(String empresanombre);
    
    @Query("Select l FROM Questskill l WHERE l.categoria_quest.id=:categoriId")
    List<QuestSkill> findByCategria_questId(@Param("Categoria_QuestId") Long categoria_questId);

    @Query(
        value ="Select * FROM questskill pregunta like CONTCAT('%',:text,'%')",
        nativeQuery = true
    )
    
    List<QuestSkill> buscarPorPreguntaNativo(@Param("text") String texto);

    
}

package com.Proyecto.SKILL_VALID.REPOSITORY;

import java.util.UUID;

import com.Proyecto.SKILL_VALID.MODELO.QuestSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.Proyecto.SKILL_VALID.MODELO.UsuarioR;


import java.util.List;


public interface ResposotoryUsuarioR extends JpaRepository<UsuarioR,UUID>{


    List<UsuarioR>findByNombreContainingIgnoreCase(String nombreUser);

  
    @Query("SELECT u FROM UsuarioR u WHERE u.questskillId =: questskillId"
    )
    QuestSkill findByQuestSkillId(Long questskillId);

    @Query(
        value = "Select * FROM usuarior u WHERE nombre LIKE CONCAT('%', :texto ,'%')",
        nativeQuery = true

    )
    List<UsuarioR>buscarPorUsuariorNativo(String texto);



    @Query(
        value = "Select u ,case WHEN u.respuestaUser > 10 THEN 'Aprobado' ELSE 'Reprobado' END AS estado FROM usuarioR u ",
        nativeQuery = true
    )
    List<UsuarioR> findPorEstados(UsuarioR u );



    


   



}

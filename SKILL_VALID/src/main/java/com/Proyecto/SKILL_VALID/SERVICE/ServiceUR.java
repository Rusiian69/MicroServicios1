package com.Proyecto.SKILL_VALID.SERVICE;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import com.Proyecto.SKILL_VALID.REPOSITORY.RepositoryQK;
import com.Proyecto.SKILL_VALID.SERVICE.ServiceUR;
import com.Proyecto.SKILL_VALID.MODELO.QuestSkill;
import com.Proyecto.SKILL_VALID.MODELO.UsuarioR;
import com.Proyecto.SKILL_VALID.MODELO.DTO.UsuarioDtoRequest;
import com.Proyecto.SKILL_VALID.MODELO.DTO.UsuarioDtoResponse;
import com.Proyecto.SKILL_VALID.REPOSITORY.ResposotoryUsuarioR;
import java.util.*;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@RequestMapping
public class ServiceUR<U> {

  private final  ResposotoryUsuarioR resposotoryUsuarioR;

  private final RepositoryQK repositoryQK;
  
  public UsuarioDtoResponse mapToDto(UsuarioR usuarioR){

   return new UsuarioDtoResponse(
    usuarioR.getUserId(),
    usuarioR.getNombreUsuario(),
    usuarioR.getRespuestaUser(),
    usuarioR.getQuestSkill().getPregunta()
   );
   }

  public List<UsuarioDtoResponse> obtenerTodas(){
    return resposotoryUsuarioR.findAll()
    .stream()
    .map(this::mapToDto)
    .collect(Collectors.toList());
  }


    public Optional<UsuarioDtoResponse> obtenerPorId(UUID id) {
        return resposotoryUsuarioR.findById(id).map(this::mapToDto);
    }

   

    public UsuarioDtoResponse guardar(UsuarioDtoRequest dto,Long id){
        QuestSkill questSkill  = resposotoryUsuarioR
        .findByQuestSkillId(dto.getQuestSkillId());
        

        UsuarioR usuarioR = new UsuarioR(
            null,
            dto.getNombreUsuario(),
            dto.getRespuestaUser(),
            questSkill
        );
        return mapToDto(resposotoryUsuarioR.save(usuarioR));

    }


    public Optional<UsuarioDtoResponse> actualizar(UUID id, UsuarioDtoRequest dto){
        return resposotoryUsuarioR.findById(id).map(existe -> {
            QuestSkill questSkill = repositoryQK
                .findById(dto.getQuestSkillId())
                .orElseThrow(() -> new RuntimeException(
                    "Categoría no encontrada con id: " + dto.getQuestSkillId()));
            existe.setNombreUsuario(dto.getNombreUsuario());
            existe.setQuestSkill(questSkill);
            existe.setRespuestaUser(dto.getRespuestaUser());
            resposotoryUsuarioR.save(existe);
            return mapToDto(existe);
        });

    }


    public List<UsuarioDtoResponse> buscarPorEstados(UsuarioR u){
        return resposotoryUsuarioR.findPorEstados(u)
        .stream().map(this::mapToDto).collect(Collectors.toList());
    }




   

    }
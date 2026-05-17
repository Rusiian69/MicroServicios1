package com.Proyecto.SKILL_VALID.SERVICE;

import com.Proyecto.SKILL_VALID.MODELO.AnswerSkill;
import com.Proyecto.SKILL_VALID.REPOSITORY.RepositoryAS;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceAS {

    private final RepositoryAS repositoryAS;

    public List<AnswerSkill> obtenerTodas(){
        return repositoryAS.findAll();
    }

    public Optional<AnswerSkill> obtenerPorId(Long id){
        return repositoryAS.findById(id);
    }

    public AnswerSkill responder(AnswerSkill answerSkill){
        return repositoryAS.save(answerSkill);
    }

    public void eliminar(Long id){
        repositoryAS.deleteById(id);
    }

    

}

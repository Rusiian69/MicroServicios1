package com.Proyecto.SKILL_VALID.config;

import com.Proyecto.SKILL_VALID.MODELO.*;
import com.Proyecto.SKILL_VALID.REPOSITORY.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    

      private RepositoryAS repositoryAS;

      private RepositoryCateQues repositoryCateQues;

      private RepositoryQK repositoryQK;
    @Override
    public void run(String... args) {
    
        if(repositoryCateQues.count() >  0 ){
            log.info(">>DataInitializer: la BD ya tiene datos , se omite a la carga de inico");
            return;
        }

        log.info(">>DataInitializer: BD vacia detectada, inserta datos de prueba ...");

        Categoria_Quest categoE = repositoryCateQues.save(
            new Categoria_Quest(null,"nivel categoria facil")); 
        Categoria_Quest categoM = repositoryCateQues.save(
            new Categoria_Quest(null,"nivel categoria medio"));
        Categoria_Quest categoD = repositoryCateQues.save(
            new Categoria_Quest(null,"nivel categoria dificil"));    
       
         UUID UUID = null;
        AnswerSkill resE1= repositoryAS.save(
            new AnswerSkill(null,"",UUID,"",null));
        AnswerSkill resE2= repositoryAS.save(
            new AnswerSkill(null,"",UUID,"",null));
        AnswerSkill resE3= repositoryAS.save(
            new AnswerSkill(null,"",UUID,"",null));
        
        AnswerSkill resM1= repositoryAS.save(
            new AnswerSkill(null,"",UUID,"",null));
        AnswerSkill resM2= repositoryAS.save(
            new AnswerSkill(null,"",UUID,"",null));
        AnswerSkill resM3= repositoryAS.save(
            new AnswerSkill(null,"",UUID,"",null)); 
        
        AnswerSkill resD1= repositoryAS.save(
            new AnswerSkill(null,"",UUID,"",null));
        AnswerSkill resD2= repositoryAS.save(
            new AnswerSkill(null,"",UUID,"",null));
        AnswerSkill resD3= repositoryAS.save(
            new AnswerSkill(null,"",UUID,"",null));
            
        repositoryQK.save(new QuestSkill(null,"",null,categoE,resE1));
        repositoryQK.save(new QuestSkill(null,"",null,categoE,resE2));
        repositoryQK.save(new QuestSkill(null,"",null,categoE,resE3));

        repositoryQK.save(new QuestSkill(null,"",null,categoM,resM1));
        repositoryQK.save(new QuestSkill(null,"",null,categoM,resM2));
        repositoryQK.save(new QuestSkill(null,"",null,categoM,resM3));

        repositoryQK.save(new QuestSkill(null,"",null,categoD,resD1));
        repositoryQK.save(new QuestSkill(null,"",null,categoD,resD2));
        repositoryQK.save(new QuestSkill(null,"",null,categoD,resD3));

        

        log.info(">>DataInitializer: {} AnswerSkill {} Categoria_Quest {} QuestSkill",
                  repositoryCateQues.count(), repositoryQK.count(), repositoryAS.count());

    } 
        
}
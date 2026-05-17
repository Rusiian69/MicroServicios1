package com.Proyecto.SKILL_VALID.CONTROLLER;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.Proyecto.SKILL_VALID.MODELO.AnswerSkill;
import com.Proyecto.SKILL_VALID.SERVICE.ServiceAS;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RestController
@RequestMapping("api/v1/answerskill")
@RequiredArgsConstructor
public class COntrollerAS {
    @Autowired
    private final ServiceAS serviceAS;

    public ResponseEntity<List<AnswerSkill>> obtenerTodas(){
        return ResponseEntity.ok(serviceAS.obtenerTodas());
    }

    public ResponseEntity<AnswerSkill> obtenerPorId(Long id){
        return serviceAS.obtenerPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<AnswerSkill> responder(AnswerSkill answerSkill){
        AnswerSkill newAS = serviceAS.responder(answerSkill);
        return ResponseEntity.status(201).body(newAS);
    }

     @PutMapping("/{id}")
    public ResponseEntity<AnswerSkill> actualizar(
                 @PathVariable Long id,
            @Valid @RequestBody AnswerSkill as) {
        return serviceAS.obtenerPorId(id)
               .map(t ->{as.setId(id);                
               return ResponseEntity.ok(serviceAS.responder(as));
               })
                .orElse(ResponseEntity.notFound().build());
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (serviceAS.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        serviceAS.eliminar(id);
        return ResponseEntity.noContent().build(); // 204
    }
    
}
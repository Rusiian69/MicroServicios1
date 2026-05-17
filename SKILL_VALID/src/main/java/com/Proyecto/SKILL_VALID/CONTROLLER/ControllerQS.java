package com.Proyecto.SKILL_VALID.CONTROLLER;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.Proyecto.SKILL_VALID.MODELO.DTO.QuestdtoRequest;
import com.Proyecto.SKILL_VALID.MODELO.DTO.Questdtoresponse;


import com.Proyecto.SKILL_VALID.SERVICE.ServiceQK;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("api/v1/questskill")
@RequiredArgsConstructor
public class ControllerQS {

    @Autowired
    private final ServiceQK serviceQK;

    public ResponseEntity<List<Questdtoresponse>> obtenerTodos(){
     return ResponseEntity.ok(serviceQK.obtenerTodos());
    }

    public ResponseEntity<Questdtoresponse> obtenerPorId(Long id){
       return serviceQK.obtenerPorId(id)
              .map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());
       
      
    }

    public ResponseEntity<Questdtoresponse> crear(@Valid QuestdtoRequest dto){
        return ResponseEntity.status(201).body(serviceQK.guardar(dto));
    }

    public ResponseEntity<Questdtoresponse> actualizar(QuestdtoRequest dto , Long id){
     return serviceQK.actualizar(id, dto)
     .map(ResponseEntity::ok)
     .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> delete(Long id){
        if (serviceQK.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        serviceQK.eliminar(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/buscar")
    public ResponseEntity<List<Questdtoresponse>> buscarNombreEmpresa(
            @RequestParam String empresanombre) {
        return ResponseEntity.ok(serviceQK.buscarNombreEmpresa(empresanombre));
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Questdtoresponse>> buscarPorCategoria(
            @PathVariable Long id) {
        return ResponseEntity.ok(serviceQK.buscarPorCategoria(id));
    }
}    
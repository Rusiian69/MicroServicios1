package com.Proyecto.SKILL_VALID.CONTROLLER;

import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyecto.SKILL_VALID.MODELO.UsuarioR;
import com.Proyecto.SKILL_VALID.MODELO.DTO.UsuarioDtoRequest;
import com.Proyecto.SKILL_VALID.MODELO.DTO.UsuarioDtoResponse;
import com.Proyecto.SKILL_VALID.SERVICE.ServiceUR;

import lombok.RequiredArgsConstructor;

import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ControllerUR {
    @SuppressWarnings("rawtypes")
    @Autowired
    private final ServiceUR serviceUR;

    @SuppressWarnings("unchecked")
    @GetMapping
     public ResponseEntity<List<UsuarioDtoResponse>> obtenerTodos() {
        return ResponseEntity.ok(serviceUR.obtenerTodas());
               
    }


    
    @SuppressWarnings("unchecked")
    @GetMapping
    public ResponseEntity<UsuarioDtoResponse> obtenerPorId(@PathVariable UUID userId){
       return (ResponseEntity<UsuarioDtoResponse>) serviceUR.obtenerPorId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

        }
    @PostMapping
    public ResponseEntity<UsuarioDtoResponse> crear(@PathVariable UsuarioDtoRequest dto,Long id){
       
        return ResponseEntity.status(201).body(serviceUR.guardar(dto, id));

    }

    @PutMapping
    @SuppressWarnings("unchecked")
    public ResponseEntity<UsuarioDtoResponse> actualizar(@PathVariable UUID id ,@RequestBody UsuarioDtoRequest dto){

        return (ResponseEntity<UsuarioDtoResponse>) serviceUR.actualizar(id, dto)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
                       
        
        
    }

    
    


}

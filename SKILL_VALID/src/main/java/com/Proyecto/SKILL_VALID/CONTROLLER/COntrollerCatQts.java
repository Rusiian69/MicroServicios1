package com.Proyecto.SKILL_VALID.CONTROLLER;

import com.Proyecto.SKILL_VALID.MODELO.Categoria_Quest;
import com.Proyecto.SKILL_VALID.SERVICE.ServiceCatQts;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
@RestController
@RequestMapping("api/v1/categoria_quest")
@AllArgsConstructor
public class COntrollerCatQts {
    @Autowired
    private final ServiceCatQts serviceCatQts;

    public ResponseEntity<List<Categoria_Quest>> obtenerTodas(){
        return ResponseEntity.ok(serviceCatQts.obtenerTodo());
    }


    public ResponseEntity<Categoria_Quest> obtenerPorId(Long id){
        return serviceCatQts.obtenerPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Categoria_Quest> crear(@Valid Categoria_Quest categoria_Quest){
        Categoria_Quest new1 = serviceCatQts.crear(categoria_Quest);
           return ResponseEntity.status(201).body(new1);

    }

    public ResponseEntity<Categoria_Quest> actualizar(Categoria_Quest atribut , long id){
             return serviceCatQts.obtenerPorId(id)
                    .map(t->{
                    atribut.setId(id);
                    return ResponseEntity.ok(serviceCatQts.crear(atribut));
                    })
                    .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> eliminar(Long id){
        if(serviceCatQts.obtenerPorId(id).isEmpty()){
            return ResponseEntity.notFound().build();

        }
        serviceCatQts.delete(id);
        return ResponseEntity.noContent().build();
    }

}

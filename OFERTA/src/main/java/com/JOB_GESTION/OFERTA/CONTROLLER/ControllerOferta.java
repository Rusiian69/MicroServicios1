package com.JOB_GESTION.OFERTA.CONTROLLER;

import com.JOB_GESTION.OFERTA.MODELO.OFERTA;
import com.JOB_GESTION.OFERTA.SERVICE.ServiceOferta;
    

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/ofertas")
@RequiredArgsConstructor
public class ControllerOferta {

    private final ServiceOferta serviceOferta;

    @GetMapping
    public ResponseEntity<List<OFERTA>> obtenerOfertas(){
        return  ResponseEntity.ok(serviceOferta.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity <OFERTA> obtenerPorId(@PathVariable Long id){
        return serviceOferta.OptenerPorID(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());

    }
     
    @PostMapping
    public ResponseEntity<OFERTA> crear(@RequestBody OFERTA oferta){

        OFERTA nueva = serviceOferta.guardar(oferta);

        return ResponseEntity.status(201).body(nueva);
    }

    @PutMapping
    public ResponseEntity<OFERTA> actualizar(@PathVariable Long id,@RequestBody OFERTA datos){

        return serviceOferta.OptenerPorID(id)
               .map(existente ->{
                  datos.setId(id);
                  return ResponseEntity.ok(serviceOferta.guardar(datos));

               })
               .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> elimnar(@PathVariable Long id){

        if(serviceOferta.OptenerPorID(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        serviceOferta.eliminar(id);
        return ResponseEntity.noContent().build();
    }


}


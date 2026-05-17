package com.empresa.empresa.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// El "name" debe ser exactamente el nombre con el que POSTULANTE se registró en Eureka
@FeignClient(name="postulante") 
public interface PostulanteFeignClient {

    // Aquí pones la ruta exacta que usarías para buscar un postulante en el otro microservicio
    // (Asegúrate de que esta ruta exista en el controlador de postulante)
    @GetMapping("/api/v1/postulantes/{id}")
    Object getPostulanteById(@PathVariable("id") Long id); 
    
    // Nota: Reemplaza "Object" por tu PostulanteDTO si tienes uno creado.
}
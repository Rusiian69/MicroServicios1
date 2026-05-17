package com.example.postulacionservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "oferta-laboral-service")
public interface OfertaClient {

    @GetMapping("/api/ofertas/{id}")
    void buscarPorId(@PathVariable("id") Long id);
}

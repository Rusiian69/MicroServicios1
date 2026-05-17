package com.example.curriculumservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "postulante-service")
public interface PostulanteClient {

    @GetMapping("/api/postulantes/{id}")
    void buscarPorId(@PathVariable("id") Long id);
}

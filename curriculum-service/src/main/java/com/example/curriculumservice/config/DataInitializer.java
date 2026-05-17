package com.example.curriculumservice.config;

import com.example.curriculumservice.model.Curriculum;
import com.example.curriculumservice.repository.CurriculumRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final CurriculumRepository repository;

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            Curriculum registro = new Curriculum();
            registro.setPostulanteId(1L);
            registro.setNombreArchivo("cv-demo.pdf");
            registro.setUrlArchivo("/archivos/cv-demo.pdf");
            registro.setFechaSubida("2026-05-04");
            repository.save(registro);
            log.info("Curriculum demo inicializado");
        }
    }
}

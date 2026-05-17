package com.example.postulacionservice.config;

import com.example.postulacionservice.model.Postulacion;
import com.example.postulacionservice.repository.PostulacionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final PostulacionRepository repository;

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            Postulacion registro = new Postulacion();
            registro.setPostulanteId(1L);
            registro.setOfertaId(1L);
            registro.setEstado("EN_REVISION");
            registro.setFechaPostulacion(LocalDate.now().toString());
            repository.save(registro);
            log.info("Postulacion demo inicializada");
        }
    }
}

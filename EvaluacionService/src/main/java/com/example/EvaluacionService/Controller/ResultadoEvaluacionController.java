package com.example.EvaluacionService.Controller;

import com.example.EvaluacionService.Model.ResultadoEvaluacion;
import com.example.EvaluacionService.Service.ResultadoEvaluacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/resultados")
@RequiredArgsConstructor
public class ResultadoEvaluacionController {

    private final ResultadoEvaluacionService service;

    @GetMapping
    public ResponseEntity<List<ResultadoEvaluacion>> listar() {
        List<ResultadoEvaluacion> lista = service.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }

    @GetMapping("/postulante/{idPostulante}")
    public ResponseEntity<List<ResultadoEvaluacion>> porPostulante(@PathVariable Long idPostulante) {
        List<ResultadoEvaluacion> lista = service.findByPostulante(idPostulante);
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<ResultadoEvaluacion> guardar(@RequestBody ResultadoEvaluacion resultado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(resultado));
    }
}
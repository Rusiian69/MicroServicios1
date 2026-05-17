package com.example.EvaluacionService.Service;

import com.example.EvaluacionService.Model.ResultadoEvaluacion;
import com.example.EvaluacionService.Repository.ResultadoEvaluacionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class ResultadoEvaluacionService {

    private final ResultadoEvaluacionRepository repository;

    public ResultadoEvaluacionService(ResultadoEvaluacionRepository repository) {
        this.repository = repository;
    }

    public ResultadoEvaluacion save(ResultadoEvaluacion resultado) {
        return repository.save(resultado);
    }

    public List<ResultadoEvaluacion> findByPostulante(Long idPostulante) {
        return repository.findByIdPostulante(idPostulante);
    }

    public List<ResultadoEvaluacion> findAll() {
        return repository.findAll();
    }
}
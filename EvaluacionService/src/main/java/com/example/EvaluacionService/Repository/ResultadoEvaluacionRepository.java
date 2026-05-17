package com.example.EvaluacionService.Repository;



import com.example.EvaluacionService.Model.ResultadoEvaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResultadoEvaluacionRepository extends JpaRepository<ResultadoEvaluacion, Long> {


    List<ResultadoEvaluacion> findByIdPostulante(Long idPostulante);
}
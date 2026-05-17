package com.example.EvaluacionService.Repository;



import com.example.EvaluacionService.Model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {

    // TIPO 1: QUERY METHOD
    // → SELECT * FROM evaluacion WHERE id_postulante = ?
    List<Evaluacion> findByIdPostulante(Long idPostulante);

}
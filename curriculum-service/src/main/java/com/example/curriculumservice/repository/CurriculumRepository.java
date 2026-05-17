package com.example.curriculumservice.repository;

import com.example.curriculumservice.model.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
List<Curriculum> findByNombreArchivoContainingIgnoreCase(String nombreArchivo);

List<Curriculum> findByPostulanteId(Long postulanteId);

}

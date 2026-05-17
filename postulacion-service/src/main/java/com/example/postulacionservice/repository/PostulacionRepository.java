package com.example.postulacionservice.repository;

import com.example.postulacionservice.model.Postulacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostulacionRepository extends JpaRepository<Postulacion, Long> {

    List<Postulacion> findByEstadoContainingIgnoreCase(String estado);

    List<Postulacion> findByPostulanteId(Long postulanteId);

    List<Postulacion> findByOfertaId(Long ofertaId);

    boolean existsByPostulanteIdAndOfertaId(Long postulanteId, Long ofertaId);
}

package com.example.NotificacionService.Repository;

import com.example.NotificacionService.Modelo.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    // TIPO 1: QUERY METHOD
    // → SELECT * FROM notificacion WHERE id_usuario = ?
    List<Notificacion> findByIdUsuario(Long idUsuario);

}
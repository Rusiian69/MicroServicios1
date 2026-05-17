package com.example.postulacionservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "notificacion-service")
public interface NotificacionClient {

    @PostMapping("/api/notificaciones")
    void crear(@RequestBody Map<String, Object> body);
}

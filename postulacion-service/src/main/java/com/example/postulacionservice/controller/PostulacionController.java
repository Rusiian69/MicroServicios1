package com.example.postulacionservice.controller;

import com.example.postulacionservice.dto.PostulacionRequestDTO;
import com.example.postulacionservice.dto.PostulacionResponseDTO;
import com.example.postulacionservice.service.PostulacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/postulaciones")
@RequiredArgsConstructor
public class PostulacionController {

    private final PostulacionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostulacionResponseDTO crear(@Valid @RequestBody PostulacionRequestDTO request) {
        return service.crear(request);
    }

    @GetMapping
    public List<PostulacionResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public PostulacionResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<PostulacionResponseDTO> buscarPorEstado(@RequestParam String estado) {
        return service.buscarPorEstado(estado);
    }

    @GetMapping("/postulanteId/{postulanteId}")
    public List<PostulacionResponseDTO> buscarPorPostulanteId(@PathVariable Long postulanteId) {
        return service.buscarPorPostulanteId(postulanteId);
    }

    @GetMapping("/ofertaId/{ofertaId}")
    public List<PostulacionResponseDTO> buscarPorOfertaId(@PathVariable Long ofertaId) {
        return service.buscarPorOfertaId(ofertaId);
    }

    @PutMapping("/{id}")
    public PostulacionResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody PostulacionRequestDTO request) {
        return service.actualizar(id, request);
    }

    @PatchMapping("/{id}/estado")
    public PostulacionResponseDTO cambiarEstado(@PathVariable Long id, @RequestBody Map<String, String> body) {
        return service.cambiarEstado(id, body.get("estado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}

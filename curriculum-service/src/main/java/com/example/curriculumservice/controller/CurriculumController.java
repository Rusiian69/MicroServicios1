package com.example.curriculumservice.controller;

import com.example.curriculumservice.dto.CurriculumRequestDTO;
import com.example.curriculumservice.dto.CurriculumResponseDTO;
import com.example.curriculumservice.service.CurriculumService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/curriculums")
@RequiredArgsConstructor
public class CurriculumController {

    private final CurriculumService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CurriculumResponseDTO crear(@Valid @RequestBody CurriculumRequestDTO request) {
        return service.crear(request);
    }

    @GetMapping
    public List<CurriculumResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public CurriculumResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

@GetMapping("/buscar")
public List<CurriculumResponseDTO> buscarPorNombreArchivo(@RequestParam String nombreArchivo) {
    return service.buscarPorNombreArchivo(nombreArchivo);
}

@GetMapping("/postulanteId/{postulanteId}")
public List<CurriculumResponseDTO> buscarPorPostulanteId(@PathVariable Long postulanteId) {
    return service.buscarPorPostulanteId(postulanteId);
}

    @PutMapping("/{id}")
    public CurriculumResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody CurriculumRequestDTO request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}

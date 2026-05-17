package com.example.curriculumservice.service;

import com.example.curriculumservice.client.PostulanteClient;
import com.example.curriculumservice.dto.CurriculumRequestDTO;
import com.example.curriculumservice.dto.CurriculumResponseDTO;
import com.example.curriculumservice.model.Curriculum;
import com.example.curriculumservice.repository.CurriculumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CurriculumService {

    private static final Set<String> FORMATOS_VALIDOS = Set.of("pdf", "doc", "docx");

    private final CurriculumRepository repository;
    private final PostulanteClient postulanteClient;

    public CurriculumResponseDTO crear(CurriculumRequestDTO request) {
        validarArchivo(request.getNombreArchivo());
        validarPostulante(request.getPostulanteId());

        Curriculum registro = new Curriculum();
        registro.setPostulanteId(request.getPostulanteId());
        registro.setNombreArchivo(request.getNombreArchivo());
        registro.setUrlArchivo(request.getUrlArchivo());
        registro.setFechaSubida(LocalDate.now().toString());
        return toDTO(repository.save(registro));
    }

    public List<CurriculumResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public CurriculumResponseDTO buscarPorId(Long id) {
        Curriculum registro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curriculum no encontrado con id: " + id));
        return toDTO(registro);
    }

    public List<CurriculumResponseDTO> buscarPorNombreArchivo(String nombreArchivo) {
        return repository.findByNombreArchivoContainingIgnoreCase(nombreArchivo)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public List<CurriculumResponseDTO> buscarPorPostulanteId(Long postulanteId) {
        return repository.findByPostulanteId(postulanteId)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public CurriculumResponseDTO actualizar(Long id, CurriculumRequestDTO request) {
        validarArchivo(request.getNombreArchivo());
        Curriculum registro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curriculum no encontrado con id: " + id));
        registro.setNombreArchivo(request.getNombreArchivo());
        registro.setUrlArchivo(request.getUrlArchivo());
        return toDTO(repository.save(registro));
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Curriculum no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }

    private void validarArchivo(String nombreArchivo) {
        if (nombreArchivo == null || !nombreArchivo.contains(".")) {
            throw new RuntimeException("El nombre del archivo debe incluir extension (pdf, doc, docx)");
        }
        String ext = nombreArchivo.substring(nombreArchivo.lastIndexOf('.') + 1).toLowerCase();
        if (!FORMATOS_VALIDOS.contains(ext)) {
            throw new RuntimeException("Formato no permitido. Solo se aceptan: pdf, doc, docx");
        }
    }

    private void validarPostulante(Long postulanteId) {
        try {
            postulanteClient.buscarPorId(postulanteId);
        } catch (Exception e) {
            throw new RuntimeException("El postulante con id " + postulanteId + " no existe");
        }
    }

    private CurriculumResponseDTO toDTO(Curriculum registro) {
        return new CurriculumResponseDTO(
                registro.getId(),
                registro.getPostulanteId(),
                registro.getNombreArchivo(),
                registro.getUrlArchivo(),
                registro.getFechaSubida()
        );
    }
}

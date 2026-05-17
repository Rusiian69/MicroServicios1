package com.example.postulacionservice.service;

import com.example.postulacionservice.client.NotificacionClient;
import com.example.postulacionservice.client.OfertaClient;
import com.example.postulacionservice.client.PostulanteClient;
import com.example.postulacionservice.dto.PostulacionRequestDTO;
import com.example.postulacionservice.dto.PostulacionResponseDTO;
import com.example.postulacionservice.model.Postulacion;
import com.example.postulacionservice.repository.PostulacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostulacionService {

    private static final Set<String> ESTADOS_VALIDOS = Set.of("EN_REVISION", "ACEPTADA", "RECHAZADA");

    private final PostulacionRepository repository;
    private final PostulanteClient postulanteClient;
    private final OfertaClient ofertaClient;
    private final NotificacionClient notificacionClient;

    public PostulacionResponseDTO crear(PostulacionRequestDTO request) {

        if (repository.existsByPostulanteIdAndOfertaId(request.getPostulanteId(), request.getOfertaId())) {
            throw new RuntimeException("El postulante ya postulo a esta oferta");
        }

        validarPostulante(request.getPostulanteId());
        validarOferta(request.getOfertaId());

        Postulacion registro = new Postulacion();
        registro.setPostulanteId(request.getPostulanteId());
        registro.setOfertaId(request.getOfertaId());
        registro.setEstado("EN_REVISION");
        registro.setFechaPostulacion(LocalDate.now().toString());
        Postulacion guardado = repository.save(registro);

        enviarNotificacion(
                guardado.getPostulanteId(),
                "Postulacion registrada",
                "Tu postulacion a la oferta " + guardado.getOfertaId() + " esta en revision."
        );
        return toDTO(guardado);
    }

    public List<PostulacionResponseDTO> listar() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public PostulacionResponseDTO buscarPorId(Long id) {
        Postulacion registro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Postulacion no encontrado con id: " + id));
        return toDTO(registro);
    }

    public List<PostulacionResponseDTO> buscarPorEstado(String estado) {
        return repository.findByEstadoContainingIgnoreCase(estado).stream().map(this::toDTO).toList();
    }

    public List<PostulacionResponseDTO> buscarPorPostulanteId(Long postulanteId) {
        return repository.findByPostulanteId(postulanteId).stream().map(this::toDTO).toList();
    }

    public List<PostulacionResponseDTO> buscarPorOfertaId(Long ofertaId) {
        return repository.findByOfertaId(ofertaId).stream().map(this::toDTO).toList();
    }

    public PostulacionResponseDTO actualizar(Long id, PostulacionRequestDTO request) {
        Postulacion registro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Postulacion no encontrado con id: " + id));
        registro.setEstado(request.getEstado());
        return toDTO(repository.save(registro));
    }

    public PostulacionResponseDTO cambiarEstado(Long id, String nuevoEstado) {
        if (nuevoEstado == null || !ESTADOS_VALIDOS.contains(nuevoEstado.toUpperCase())) {
            throw new RuntimeException("Estado invalido. Debe ser EN_REVISION, ACEPTADA o RECHAZADA");
        }
        Postulacion registro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Postulacion no encontrado con id: " + id));
        registro.setEstado(nuevoEstado.toUpperCase());
        Postulacion guardado = repository.save(registro);

        enviarNotificacion(
                guardado.getPostulanteId(),
                "Cambio de estado de postulacion",
                "Tu postulacion " + guardado.getId() + " ahora esta en estado: " + guardado.getEstado()
        );
        return toDTO(guardado);
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Postulacion no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }

    private void validarPostulante(Long postulanteId) {
        try {
            postulanteClient.buscarPorId(postulanteId);
        } catch (Exception e) {
            throw new RuntimeException("El postulante con id " + postulanteId + " no existe");
        }
    }

    private void validarOferta(Long ofertaId) {
        try {
            ofertaClient.buscarPorId(ofertaId);
        } catch (Exception e) {
            throw new RuntimeException("La oferta con id " + ofertaId + " no existe");
        }
    }

    private void enviarNotificacion(Long usuarioId, String titulo, String mensaje) {
        Map<String, Object> body = new HashMap<>();
        body.put("usuarioId", usuarioId);
        body.put("titulo", titulo);
        body.put("mensaje", mensaje);
        body.put("estado", "PENDIENTE");
        try {
            notificacionClient.crear(body);
        } catch (Exception e) {
            System.err.println("[NotificacionClient] No se pudo enviar notificacion: " + e.getMessage());
        }
    }

    private PostulacionResponseDTO toDTO(Postulacion r) {
        return new PostulacionResponseDTO(
                r.getId(), r.getPostulanteId(), r.getOfertaId(),
                r.getEstado(), r.getFechaPostulacion()
        );
    }
}

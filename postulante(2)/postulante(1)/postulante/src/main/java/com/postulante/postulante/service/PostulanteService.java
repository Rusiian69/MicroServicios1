package com.postulante.postulante.service;


import com.postulante.postulante.model.Postulante;
import com.postulante.postulante.repository.PostulanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostulanteService {

    private final PostulanteRepository repository;

    public List<Postulante> listar() {
        return repository.findAll();
    }

    public Postulante guardar(Postulante p) {
        return repository.save(p);
    }

    public List<Postulante>buscarPorEmail(String correo){
        return repository.buscarPorCorreoExacto(correo);
    }



}


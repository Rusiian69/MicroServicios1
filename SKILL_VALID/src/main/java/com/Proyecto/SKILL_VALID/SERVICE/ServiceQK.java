package com.Proyecto.SKILL_VALID.SERVICE;

import com.Proyecto.SKILL_VALID.MODELO.DTO.QuestdtoRequest;
import com.Proyecto.SKILL_VALID.MODELO.AnswerSkill;
import com.Proyecto.SKILL_VALID.MODELO.Categoria_Quest;
import com.Proyecto.SKILL_VALID.MODELO.QuestSkill;
import com.Proyecto.SKILL_VALID.MODELO.DTO.Questdtoresponse;
import com.Proyecto.SKILL_VALID.REPOSITORY.RepositoryQK;
import com.Proyecto.SKILL_VALID.REPOSITORY.RepositoryCateQues;
import com.Proyecto.SKILL_VALID.REPOSITORY.RepositoryAS;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceQK {
    private final RepositoryQK repositoryQK;

    private final RepositoryCateQues repositoryCateQues;

    private final RepositoryAS repositoryAS;

    private Questdtoresponse mapToDTO(QuestSkill questSkill){
        return new Questdtoresponse(
            questSkill.getId(), 
            questSkill.getPregunta(), 
            questSkill.getEmpresaId(),
            questSkill.getCategoria_Quest().getNombre_categoria(), 
            questSkill.getAnswerSkill().getRespuesta()
        );
    }

     public List<Questdtoresponse> obtenerTodos() {
        return repositoryQK.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ── OBTENER POR ID ───────────────────────────────
    public Optional<Questdtoresponse> obtenerPorId(Long id) {
        return repositoryQK.findById(id).map(this::mapToDTO);
    }

    // ── GUARDAR ──────────────────────────────────────
    // Antes: recibía Libro. Ahora: recibe LibroRequestDTO.
    // Si el categoriaId no existe, lanza RuntimeException.
    // GlobalExceptionHandler la captura y devuelve 400.
    public Questdtoresponse guardar(QuestdtoRequest dto) {
        Categoria_Quest categoria_Quest = repositoryCateQues
                .findById(dto.getCategoria_questId())
                .orElseThrow(() -> new RuntimeException(
                        "Categoría no encontrada con id: " + dto.getCategoria_questId()));

        AnswerSkill answerskill = repositoryAS
                .findById(dto.getAnswerSkill_Id())
                .orElseThrow(() -> new RuntimeException(
                    "Respuesta no esta vincualda" + dto.getAnswerSkill_Id()));

        QuestSkill questSkill = new QuestSkill(
                null,
                dto.getPregunta(),
                dto.getEmpresaId(),
                categoria_Quest,
                answerskill                
        
        );
        return mapToDTO(repositoryQK.save(questSkill));
    }

    // ── ACTUALIZAR ───────────────────────────────────
    public Optional<Questdtoresponse> actualizar(Long id, QuestdtoRequest dto) {
        return repositoryQK.findById(id).map(existente -> {
           Categoria_Quest categoria_Quest  = repositoryCateQues
                    .findById(dto.getCategoria_questId())
                    .orElseThrow(() -> new RuntimeException(
                            "Categoría no encontrada con id: " + dto.getCategoria_questId()));
            AnswerSkill answerSkill  = repositoryAS
                    .findById(dto.getAnswerSkill_Id())
                    .orElseThrow(() -> new RuntimeException(
                            "Categoría no encontrada con id: " + dto.getAnswerSkill_Id()));

            existente.setPregunta(dto.getPregunta());
            existente.setCategoria_Quest(categoria_Quest);
            existente.setAnswerSkill(answerSkill);
            return mapToDTO(repositoryQK.save(existente));
        });
    }

    // ── ELIMINAR ─────────────────────────────────────
    public void eliminar(Long id) {
        repositoryQK.deleteById(id);
    }

    // ── BÚSQUEDAS (de Clase 2, adaptadas a ResponseDTO) ──
   

    public List<Questdtoresponse> buscarPorCategoria(Long categoriaId) {
        return repositoryQK.findByCategria_questId(categoriaId)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<Questdtoresponse> buscarNombreEmpresa(String empresanombre) {
        return repositoryQK.findByEmpresaNombreContainigIgnoreCase(empresanombre)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
 /*    
    public List<QuestSkill> obtenerTodas(){
        return repositoryQK.findAll();
    }

    public Optional<QuestSkill> obtenerPorId(Long id){
        return repositoryQK.findById(id);
    }

    public QuestSkill guardar(QuestSkill questSkill){
        return repositoryQK.save(questSkill);
    }

    public void eliminar(Long id){
    repositoryQK.deleteById(id);
    }
    */

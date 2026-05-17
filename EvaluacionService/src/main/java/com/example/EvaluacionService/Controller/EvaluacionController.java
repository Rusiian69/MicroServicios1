package com.example.EvaluacionService.Controller;



import com.example.EvaluacionService.Model.Evaluacion;
import com.example.EvaluacionService.Service.EvaluacionService;
import com.example.EvaluacionService.dto.EvaluacionDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/evaluaciones")
public class EvaluacionController {
    @Autowired
    private EvaluacionService service;

    @GetMapping
    public ResponseEntity<List<Evaluacion>> listar() {
        List<Evaluacion> lista = service.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Evaluacion> guardar(@RequestBody @Valid EvaluacionDTO dto) {
        Evaluacion e = new Evaluacion(null, dto.getIdEmpresa(), dto.getIdPostulante(),
                dto.getPuntaje(), dto.getComentarios());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(e));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> buscar(@PathVariable Long id) {
        try { return ResponseEntity.ok(service.findById(id)); }
        catch (Exception e) { return ResponseEntity.notFound().build(); }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try { service.delete(id); return ResponseEntity.noContent().build(); }
        catch (Exception e) { return ResponseEntity.notFound().build(); }
    }
}

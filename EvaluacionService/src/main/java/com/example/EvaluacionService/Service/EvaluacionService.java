package com.example.EvaluacionService.Service;




import com.example.EvaluacionService.Model.Evaluacion;
import com.example.EvaluacionService.Repository.EvaluacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class EvaluacionService {
    @Autowired
    private EvaluacionRepository repository;

    public List<Evaluacion> findAll() { return repository.findAll(); }
    public Evaluacion findById(Long id) { return repository.findById(id).get(); }
    public Evaluacion save(Evaluacion evaluacion) { return repository.save(evaluacion); }
    public void delete(Long id) { repository.deleteById(id); }
}

package com.Proyecto.SKILL_VALID.SERVICE;
import com.Proyecto.SKILL_VALID.MODELO.Categoria_Quest;
import com.Proyecto.SKILL_VALID.REPOSITORY.RepositoryCateQues;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceCatQts {

    private final RepositoryCateQues repositoryCateQues;

    public List<Categoria_Quest> obtenerTodo(){
        return repositoryCateQues.findAll();
    }

    public Optional<Categoria_Quest> obtenerPorId(Long id){
        return repositoryCateQues.findById(id);
    }

    public Categoria_Quest crear(Categoria_Quest categoria_Quest){
        return repositoryCateQues.save(categoria_Quest);
    }

  
    public void delete(Long id){
     repositoryCateQues.deleteById(id);
    }
}

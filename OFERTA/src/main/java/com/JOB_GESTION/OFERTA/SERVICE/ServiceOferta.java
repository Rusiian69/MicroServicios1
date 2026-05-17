package com.JOB_GESTION.OFERTA.SERVICE;

import com.JOB_GESTION.OFERTA.MODELO.dto.dtoRequestOferta;
import com.JOB_GESTION.OFERTA.MODELO.dto.dtoResponseOferta;
import com.JOB_GESTION.OFERTA.MODELO.OFERTA;
import com.JOB_GESTION.OFERTA.REPOSITORY.RepositoryOferta;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceOferta {

    private final RepositoryOferta repositoryOferta;

    public dtoResponseOferta mapToDTO(OFERTA oferta){

        return new dtoResponseOferta(
            oferta.getId(),
            oferta.getTitulo(),
            oferta.getDescripcion(),
            oferta.getRequisito(),
            oferta.getEmpresaId()
        );
    }

        public List<dtoResponseOferta> obtenerTodos() {
        return repositoryOferta.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Optional<dtoResponseOferta> obtenerPorId(Long id) {
        return repositoryOferta.findById(id).map(this::mapToDTO);
    }

      public dtoResponseOferta guardar(dtoRequestOferta dto) {
        
        OFERTA oferta = new OFERTA(
                null,
                dto.getTitulo(),
                dto.getDescripcion(),
                dto.getRequisito(),
                dto.getEmpresaId()      
        );
        return mapToDTO(repositoryOferta.save(oferta));
    }
  /*   public List<OFERTA> obtenerTodas(){
        return RepositoryOferta.findAll();
    }


    public Optional<OFERTA>OptenerPorID(Long id){
        return RepositoryOferta.findById(id);
    }
    

    public OFERTA guardar(OFERTA oferta){
        return RepositoryOferta.save(oferta);
    }

    
    public void eliminar(Long id){
     RepositoryOferta.deleteById(id);

    }   
 */

}

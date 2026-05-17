package cvservice.cvservice.repository;

import cvservice.cvservice.model.ArchivoCV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository

public interface CVRepository extends JpaRepository<ArchivoCV, Long> {


    List<ArchivoCV> findByPostulanteId(Long postulanteId);

}
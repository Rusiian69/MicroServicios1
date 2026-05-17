package cvservice.cvservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "archivos_cv")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ArchivoCV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreOriginal;
    private String nombreAlmacenado;
    private String rutaArchivo;
    private Long postulanteId;

}
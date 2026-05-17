package cvservice.cvservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;



@Data
public class ArchivoCV_DTO {
    @NotBlank(message = "El nombre original es obligatorio")
    private String nombreOriginal;

    @NotBlank(message = "El nombre almacenado es obligatorio")
    private String nombreAlmacenado;

    @NotNull(message = "El ID del postulante es obligatorio")
    private Long postulanteId;

    private String mensaje;

}
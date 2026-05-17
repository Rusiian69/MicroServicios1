package cvservice.cvservice.controller;


import cvservice.cvservice.dto.ArchivoCV_DTO;
import cvservice.cvservice.model.ArchivoCV;
import cvservice.cvservice.service.CVService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/api/cv")
public class CVController {
    private final CVService service;
    public CVController(CVService service) {
        this.service = service;

    }



    @PostMapping("/upload/{postulanteId}")
    public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo,
                                    @PathVariable Long postulanteId) {

        try {
            ArchivoCV res = service.subirArchivo(archivo, postulanteId);

            ArchivoCV_DTO dto = new ArchivoCV_DTO();
            dto.setNombreOriginal(res.getNombreOriginal());
            dto.setNombreAlmacenado(res.getNombreAlmacenado());
            dto.setPostulanteId(res.getPostulanteId());
            dto.setMensaje("Subido con éxito");



            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

}
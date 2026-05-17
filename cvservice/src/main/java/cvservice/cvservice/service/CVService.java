package cvservice.cvservice.service;


import cvservice.cvservice.model.ArchivoCV;
import cvservice.cvservice.repository.CVRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;

@Service
public class CVService {
    private final String UPLOAD_DIR = "uploads/cvs/";
    private final CVRepository repository;

    public CVService(CVRepository repository) {
        this.repository = repository;

    }



    public ArchivoCV subirArchivo(MultipartFile archivo, Long postulanteId) throws IOException {

        // 1. VALIDACIONES

        if (!archivo.getContentType().equals("application/pdf")) {
            throw new RuntimeException("Solo se permiten archivos PDF.");

        }

        if (archivo.getSize() > 5 * 1024 * 1024) {
            throw new RuntimeException("El archivo supera el límite de 5MB.");

        }



        // 2. CREAR CARPETA

        Path directorio = Paths.get(UPLOAD_DIR);
        if (!Files.exists(directorio)) {
            Files.createDirectories(directorio);

        }



        // 3. GUARDAR FÍSICAMENTE
        String nombreFinal = System.currentTimeMillis() + "_" + archivo.getOriginalFilename();
        Path destino = directorio.resolve(nombreFinal);
        Files.copy(archivo.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);



        // 4. GUARDAR EN BD

        ArchivoCV cv = new ArchivoCV();
        cv.setNombreOriginal(archivo.getOriginalFilename());
        cv.setNombreAlmacenado(nombreFinal);
        cv.setRutaArchivo(destino.toString());
        cv.setPostulanteId(postulanteId);


        return repository.save(cv);

    }

}
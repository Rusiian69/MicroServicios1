package com.JOB_GESTION.OFERTA.REPOSITORY;

import com.JOB_GESTION.OFERTA.MODELO.OFERTA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryOferta extends JpaRepository<OFERTA,Long>  {


    // → SELECT * FROM libros WHERE UPPER(titulo) LIKE UPPER('%?%')
    List<OFERTA> findByTituloContainingIgnoreCase(String titulo);

    // → SELECT * FROM libros WHERE precio < ?
    List<OFERTA> findByRequisitoContainingIgnoreCase(String requisito);

    // → SELECT * FROM libros WHERE precio BETWEEN ? AND ?
    List<OFERTA> findByEmpresaNombreContainingIgnoreCase(String empresanombre);


    // ── TIPO 2: @QUERY CON JPQL ──────────────────────
    // Escrito sobre entidades Java, NO sobre tablas SQL.
    // "Libro" = clase Java,  "l.categoria.id" = atributo.
    // Hibernate lo traduce al SQL correcto según el dialecto.
    // :param es parámetro nombrado, @Param lo enlaza.
    @Query("SELECT 0 FROM OFERTA 0 WHERE 0.categoria.id = :categoriaId")
    List<OFERTA> findByIdOferta(@Param("categoriaId") Long id);

    // JPQL con ORDER BY
   

    // ── TIPO 3: SQL NATIVO ───────────────────────────
    // nativeQuery=true: Hibernate manda el SQL tal cual a MySQL.
    // Usar para funciones específicas de MySQL (CONCAT, DATE_FORMAT...)
    // o consultas muy optimizadas que no deben ser reescritas.
    @Query(
        value = "SELECT * FROM libros WHERE titulo LIKE CONCAT('%', :texto, '%')",
        nativeQuery = true
    )
    List<OFERTA> buscarPorTituloNativo(@Param("texto") String texto);

}

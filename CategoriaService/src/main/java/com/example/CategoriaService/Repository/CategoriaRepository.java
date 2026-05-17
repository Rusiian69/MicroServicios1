package com.example.CategoriaService.Repository;



import com.example.CategoriaService.Model.Categoria;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;



import java.util.List;




@Repository

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


    @Query("SELECT c FROM Categoria c WHERE c.nombre LIKE %:texto%")

    List<Categoria> buscarPorNombreJPQL(@Param("texto") String texto);



}


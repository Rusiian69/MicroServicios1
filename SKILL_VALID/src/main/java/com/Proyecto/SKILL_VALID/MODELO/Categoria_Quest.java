package com.Proyecto.SKILL_VALID.MODELO;

import org.springframework.data.annotation.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Categoria_quest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria_Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotEmpty(message = "La variable nombre_categoria no puede estar vacia")
    @Column(length = 55 )
    private String nombre_categoria;


    

}

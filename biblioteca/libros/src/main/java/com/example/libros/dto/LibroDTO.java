package com.example.libros.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO {
    private Long isbn;
    private String titulo;
    private int anioPublicacion;
    private String descripcion;
}

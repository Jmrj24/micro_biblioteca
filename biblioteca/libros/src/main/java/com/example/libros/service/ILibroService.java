package com.example.libros.service;

import com.example.libros.dto.LibroDTO;
import com.example.libros.model.Libro;

import java.util.List;

public interface ILibroService {
    public void saveLibro(LibroDTO libroDTO);

    public List<Libro> getAllLibros();

    public Libro getLibroById(Long id);

    public void deleteLibroById(Long id);

    public void editLibro(Libro libro);
}

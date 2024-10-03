package com.example.libros.controller;

import com.example.libros.dto.LibroDTO;
import com.example.libros.model.Libro;
import com.example.libros.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/libros")
public class LibroController {
    @Autowired
    private ILibroService libroServi;

    @PostMapping("/crear")
    public String saveLibro(@RequestBody LibroDTO libroDTO) {
        libroServi.saveLibro(libroDTO);
        return "Libro creado correctamente";
    }

    @GetMapping("/traer")
    public List<Libro> traerLibros() {
        return libroServi.getAllLibros();
    }

    @DeleteMapping("/borrar/{idLibro}")
    public String deleteLibro(@PathVariable Long idLibro) {
        libroServi.deleteLibroById(idLibro);
        return "Libro eliminado correctamente";
    }

    @PutMapping("/editar")
    public Libro editLibro(@RequestBody Libro libro) {
        libroServi.editLibro(libro);
        return libroServi.getLibroById(libro.getId());
    }
}

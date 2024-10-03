package com.example.autores.controller;

import com.example.autores.model.Autor;
import com.example.autores.service.IAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/autores")
public class AutorController {
    @Autowired
    private IAutorService autorServi;

    @PostMapping("/crear")
    public String saveAutor(@RequestBody Autor autor) {
        autorServi.saveAutor(autor);
        return "Autor creado correctamente";
    }

    @GetMapping("/traer")
    public List<Autor> getAllAutores() {
        return autorServi.getAllAutores();
    }

    @DeleteMapping("/borrar/{idAutor}")
    public String deleteAutor(@PathVariable Long idAutor) {
        autorServi.deleteAutorById(idAutor);
        return "Autor eliminado correctamente";
    }

    @PutMapping("/editar")
    public Autor editAutor(@RequestBody Autor autor) {
        autorServi.editAutor(autor);
        return autorServi.getAutorById(autor.getId());
    }

    @GetMapping("/traerisbn/{isbn}")
    public List<Autor> getAutoresByISBN(@PathVariable Long isbn) {
        return autorServi.getAutorByIsbn(isbn);
    }
}

package com.example.libros.service;

import com.example.libros.dto.AutoresDTO;
import com.example.libros.dto.LibroDTO;
import com.example.libros.model.Libro;
import com.example.libros.repository.IAutoresAPIClient;
import com.example.libros.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroService implements ILibroService {
    @Autowired
    private ILibroRepository libroRepo;

    @Autowired
    private IAutoresAPIClient iautoresAPIClient;

    @Override
    public void saveLibro(LibroDTO libroDTO) {
        Libro libro = new Libro();
        List<AutoresDTO> listaAutoresDTO = iautoresAPIClient.traerAutores(libroDTO.getIsbn());
        List<String> listaAutores = new ArrayList<>();

        libro.setIsbn(libroDTO.getIsbn());
        libro.setTitulo(libroDTO.getTitulo());
        libro.setAnioPublicacion(libroDTO.getAnioPublicacion());
        libro.setDescripcion(libroDTO.getDescripcion());
        for(AutoresDTO autor : listaAutoresDTO) {
            listaAutores.add(autor.getNombreCompleto()+" "+autor.getNacionalidad());
        }
        libro.setAutores(listaAutores);
        libroRepo.save(libro);
    }

    @Override
    public List<Libro> getAllLibros() {
        return libroRepo.findAll();
    }

    @Override
    public Libro getLibroById(Long id) {
        return libroRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteLibroById(Long id) {
        libroRepo.deleteById(id);
    }

    @Override
    public void editLibro(Libro libro) {
        libroRepo.save(libro);
    }
}

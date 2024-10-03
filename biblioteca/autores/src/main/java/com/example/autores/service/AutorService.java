package com.example.autores.service;

import com.example.autores.model.Autor;
import com.example.autores.repository.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService implements IAutorService {
    @Autowired
    private IAutorRepository autorRepo;

    @Override
    public void saveAutor(Autor autor) {
        autorRepo.save(autor);
    }

    @Override
    public List<Autor> getAllAutores() {
        return autorRepo.findAll();
    }

    @Override
    public Autor getAutorById(Long id) {
        return autorRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteAutorById(Long id) {
        autorRepo.deleteById(id);
    }

    @Override
    public void editAutor(Autor autor) {
        this.saveAutor(autor);
    }

    @Override
    public List<Autor> getAutorByIsbn(Long isbn) {
        return autorRepo.findAutorIsbn(isbn);
    }
}

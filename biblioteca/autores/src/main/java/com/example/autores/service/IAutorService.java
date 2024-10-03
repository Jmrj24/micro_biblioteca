package com.example.autores.service;

import com.example.autores.model.Autor;

import java.util.List;

public interface IAutorService {
    public void saveAutor(Autor autor);

    public List<Autor> getAllAutores();

    public Autor getAutorById(Long id);

    public void deleteAutorById(Long id);

    public void editAutor(Autor autor);

    public List<Autor> getAutorByIsbn(Long isbn);
}

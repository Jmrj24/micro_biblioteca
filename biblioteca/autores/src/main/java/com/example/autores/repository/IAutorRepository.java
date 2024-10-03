package com.example.autores.repository;

import com.example.autores.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE :isbn MEMBER OF a.libros")
    List<Autor> findAutorIsbn(Long isbn);
}

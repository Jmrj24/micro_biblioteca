package com.example.libros.repository;

import com.example.libros.dto.AutoresDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "autoresapi", url ="http://localhost:9001/autores")
public interface IAutoresAPIClient {
    @GetMapping("/traerisbn/{isbn}")
    public List<AutoresDTO> traerAutores(@PathVariable ("isbn") Long isbn);
}

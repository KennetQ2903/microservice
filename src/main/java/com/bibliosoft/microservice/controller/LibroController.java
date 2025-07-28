package com.bibliosoft.microservice.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibliosoft.microservice.dto.LibroDto;
import com.bibliosoft.microservice.service.LibroService;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<LibroDto> obtenerTodos() {
        return libroService.obtenerTodos();
    }

    @PostMapping
    public LibroDto agregarLibro(@RequestBody LibroDto libro) {
        return libroService.agregarLibro(libro);
    }

    @GetMapping("/{id}")
    public LibroDto obtenerPorId(@PathVariable Long id) {
        return libroService.obtenerPorId(id)
            .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        if (!libroService.eliminarLibro(id)) {
            throw new RuntimeException("No se pudo eliminar el libro");
        }
    }
}

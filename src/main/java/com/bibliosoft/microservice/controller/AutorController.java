package com.bibliosoft.microservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibliosoft.microservice.dto.AutorDTO;
import com.bibliosoft.microservice.service.AutorService;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<AutorDTO> obtenerTodos() {
        return autorService.obtenerTodos();
    }

    @PostMapping
    public AutorDTO agregarAutor(@RequestBody AutorDTO autor) {
        return autorService.agregarAutor(autor);
    }

    @GetMapping("/{id}")
    public AutorDTO obtenerPorId(@PathVariable Long id) {
        return autorService.obtenerPorId(id)
            .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void eliminarAutor(@PathVariable Long id) {
        if (!autorService.eliminarAutor(id)) {
            throw new RuntimeException("No se pudo eliminar el autor");
        }
    }
}

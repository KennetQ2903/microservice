package com.bibliosoft.microservice.service;
import org.springframework.stereotype.Service;

import com.bibliosoft.microservice.dto.LibroDto;

import java.util.*;

@Service
public class LibroService {
    private final Map<Long, LibroDto> libros = new HashMap<>();
    private Long idCounter = 1L;

    public List<LibroDto> obtenerTodos() {
        return new ArrayList<>(libros.values());
    }

    public LibroDto agregarLibro(LibroDto libro) {
        libro.setId(idCounter++);
        libros.put(libro.getId(), libro);
        return libro;
    }

    public Optional<LibroDto> obtenerPorId(Long id) {
        return Optional.ofNullable(libros.get(id));
    }

    public boolean eliminarLibro(Long id) {
        return libros.remove(id) != null;
    }
}

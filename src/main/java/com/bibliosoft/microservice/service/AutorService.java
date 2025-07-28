package com.bibliosoft.microservice.service;


import org.springframework.stereotype.Service;

import com.bibliosoft.microservice.dto.AutorDTO;

import java.util.*;

@Service
public class AutorService {
    private final Map<Long, AutorDTO> autores = new HashMap<>();
    private Long idCounter = 1L;

    public List<AutorDTO> obtenerTodos() {
        return new ArrayList<>(autores.values());
    }

    public AutorDTO agregarAutor(AutorDTO autor) {
        autor.setId(idCounter++);
        autores.put(autor.getId(), autor);
        return autor;
    }

    public Optional<AutorDTO> obtenerPorId(Long id) {
        return Optional.ofNullable(autores.get(id));
    }

    public boolean eliminarAutor(Long id) {
        return autores.remove(id) != null;
    }
}

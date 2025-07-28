package com.bibliosoft.microservice.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.bibliosoft.microservice.dto.UsuarioDTO;

@Service
public class UsuarioService {
    private final Map<Long, UsuarioDTO> usuarios = new HashMap<>();
    private Long idCounter = 1L;

    public List<UsuarioDTO> obtenerTodos() {
        return new ArrayList<>(usuarios.values());
    }

    public UsuarioDTO agregarUsuario(UsuarioDTO usuario) {
        usuario.setId(idCounter++);
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    public Optional<UsuarioDTO> obtenerPorId(Long id) {
        return Optional.ofNullable(usuarios.get(id));
    }

    public boolean eliminarUsuario(Long id) {
        return usuarios.remove(id) != null;
    }
}
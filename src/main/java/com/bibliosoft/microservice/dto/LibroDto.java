package com.bibliosoft.microservice.dto;

public class LibroDto {
     private Long id;
    private String titulo;
    private String autor; // Nombre del autor
    private boolean prestado;

    public LibroDto() {}

    public LibroDto(Long id, String titulo, String autor, boolean prestado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = prestado;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
}

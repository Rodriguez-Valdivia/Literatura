package com.alura.literatura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private String idioma;
    private int descargas;
    @ManyToOne
    private Autor autor;

    public Libro(){}

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.title();
        this.idioma = datosLibro.languages().get(0);
        this.descargas = datosLibro.downloadCount();
        this.autor = new Autor(datosLibro.authors().get(0));
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

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getDescargas() {
        return descargas;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "\n-------------LIBRO---------" + "\n" +
                "Titulo: " + titulo +"\n" +
                "Autor: " + autor.getNombre() +"\n" +
                "Idioma: " + idioma +"\n" +
                "Número de descargas: " + descargas +"\n" +
                "---------------------------";
    }
}

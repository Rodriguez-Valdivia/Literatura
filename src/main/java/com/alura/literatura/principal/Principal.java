package com.alura.literatura.principal;

import com.alura.literatura.model.Autor;
import com.alura.literatura.model.DatosLibro;
import com.alura.literatura.model.Libro;
import com.alura.literatura.model.RespuestaApi;
import com.alura.literatura.repository.AutorRepository;
import com.alura.literatura.repository.LibroRepository;
import com.alura.literatura.servicio.ConsumoAPI;
import com.alura.literatura.servicio.ConvierteDatos;

import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final Scanner teclado = new Scanner(System.in);
    private final ConsumoAPI consumoAPI = new ConsumoAPI();
    private final ConvierteDatos conversor = new ConvierteDatos();
    private AutorRepository autorRepository;
    private LibroRepository libroRepository;

    public Principal(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
    }

    public void menu(){
        var opcion = "-1";
        while(!opcion.equals("0")){
            var menu = """
                    -----------------------------------------------
                    Elija la opción a través de su número
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextLine();

            switch (opcion){
                case "1":
                    buscarLibroAPi();
                    break;
                case "2":
                    listarLibros();
                    break;
                case "3":
                    listarAutores();
                    break;
                case "4":
                    buscarAutores();
                    break;
                case "5":
                    buscarLibros();
                    break;
                case "0":
                    System.out.println("Cerrando aplicación");
                    break;
                default:
                    System.out.println("Elija una opción válida");
            }
        }
    }

    private void buscarLibroAPi(){
        System.out.println("Ingrese el nombre del libro que desee buscar");
        var tituloLibro = teclado.nextLine();
        String URL_BASE = "https://gutendex.com/books/?search=";
        var json = consumoAPI.obtenerDatos(URL_BASE +tituloLibro.replace(" ", "%20"));
        var res = conversor.obtenerDatos(json, RespuestaApi.class);
        Optional<DatosLibro> optionalDatosLibro = res.results().stream().findFirst();
        if(optionalDatosLibro.isPresent()){
            DatosLibro libroEncontrado = optionalDatosLibro.get();

            Optional<Libro> optionalLibro = libroRepository.findByTitulo(libroEncontrado.title());
            if(optionalLibro.isPresent()){
                System.out.println("No se puede registrar el mismo libro más de una vez");
                return;
            }

            Optional<Autor> optionalAutor = autorRepository.findByNombre(libroEncontrado.authors().get(0).name());
            Autor autor;

            if(optionalAutor.isPresent()){
                autor = optionalAutor.get();
            } else {
                autor = new Autor(libroEncontrado.authors().get(0));
                autorRepository.save(autor);
            }
            Libro libro = new Libro(libroEncontrado);
            libro.setAutor(autor);
            libroRepository.save(libro);
            System.out.println(libro);
        }else {
            System.out.println("Libro no encontrado");
        }
    }

    private void listarLibros(){
        var libros = libroRepository.findAll();
        if(libros.isEmpty()){
            System.out.println("No hay libros registrados");
        } else {
            libros.forEach(System.out::println);
        }
    }

    private void listarAutores(){
        var autores = autorRepository.findAll();
        if(autores.isEmpty()){
            System.out.println("No se encuentran autores registrados");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void buscarAutores(){
        System.out.println("Ingrese el año vivo de autor(es) que desee buscar");
        var fecha = teclado.nextInt();
        teclado.nextLine();
        var autores = autorRepository.findAutoresVivos(fecha);
        if(autores.isEmpty()){
            System.out.println("No se encontraron autores vivos en el año mencionado");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void buscarLibros(){
        System.out.println("Ingrese el idioma para buscar los libros");
        var listaDeIdiomas = """
                es- español
                en- inglés
                fr- francés
                pt- portugués
                """;
        System.out.println(listaDeIdiomas);
        var idioma = teclado.nextLine();
        var libros = libroRepository.findByIdioma(idioma);

        if(libros.isEmpty()){
            System.out.println("No se encontraron libros en el idioma seleccionado");
        } else {
            libros.forEach(System.out::println);
        }
    }
}

package com.alura.literatura;

import com.alura.literatura.model.Autor;
import com.alura.literatura.model.DatosLibro;
import com.alura.literatura.model.Libro;
import com.alura.literatura.model.RespuestaApi;
import com.alura.literatura.principal.Principal;
import com.alura.literatura.repository.AutorRepository;
import com.alura.literatura.repository.LibroRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {
	@Autowired
	LibroRepository libroRepository;

	@Autowired
	AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Principal principal = new Principal(autorRepository, libroRepository);
		principal.menu();
	}
}

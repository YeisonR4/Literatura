package com.ChallengeLibro.Literatura.Principal;


import com.ChallengeLibro.Literatura.Model.Autores;
import com.ChallengeLibro.Literatura.Model.DatosLibros;
import com.ChallengeLibro.Literatura.Model.Libros;
import com.ChallengeLibro.Literatura.Repository.Repository;
import com.ChallengeLibro.Literatura.Service.ConsumoApi;
import com.ChallengeLibro.Literatura.Service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Repository repositorio;
    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosLibros> datosSeries = new ArrayList<>();
    private List<Libros> libros;
    private List<Libros> autores;
    private Optional<Libros> librobuscado;

    public Principal(Repository repository) {
        this.repositorio = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por titulo 
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado tiempo
                    5 - Listar libros por idioma

                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    mostrarLibrosRegistrados();
                    break;
                case 3:
                    mostrarAutoresRegistrados();
                    break;
                case 4:
                    buscarAutoresVivos();
                    break;
                case 5:
                    buscarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");


            }
        }
    }

    private void buscarLibroPorTitulo(){
        System.out.println("Escriba el nombre del titulo del libro");
        var titulo = teclado.nextInt();
        librobuscado = repositorio.indByTituloContainsIgnoreCase(String.valueOf(titulo));
        if(librobuscado.isPresent()){
            System.out.println("El libro buscada es: " + librobuscado.get());
        } else {
            System.out.println("Libro no encontrada");
        }


    }

    private void mostrarLibrosRegistrados(){
        libros = repositorio.findAll();
        libros.stream()
                .forEach(System.out::println);
    }

    private void mostrarAutoresRegistrados(){
        autores = repositorio.findAll();
        autores.stream()
                .forEach(System.out::println);
    }

    private void buscarAutoresVivos(){
        List<Autores> autoresVivos = repositorio.findByFechaMuerteIsNull();
        autoresVivos.forEach(l -> System.out.println(l.getNombre()));
    }

    private void buscarLibrosPorIdioma(){
        List<Libros> librosIdioma = repositorio.findByIdioma();
        librosIdioma.forEach(l-> System.out.println(l.getTitulo()));
    }
}

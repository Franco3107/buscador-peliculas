package com.miempresa.buscadorpeliculas;

import java.io.IOException;
import java.util.Scanner;

import com.miempresa.buscadorpeliculas.exception.PeliculaNoEncontradaException;
import com.miempresa.buscadorpeliculas.service.OmdbClient;

public class App {
    public static void main(String[] args) throws IOException, PeliculaNoEncontradaException {
        Scanner scanner = new Scanner(System.in);
        int key=0;
        OmdbClient client = new OmdbClient();
        do {
            System.out.println("Ingrese 1: Para elegir pelicula o 2: para Salir del programa");
            key = scanner.nextInt();
            switch (key) {
			case 1:
		          try {
		        	  System.out.println("Ingresá el título de una película o serie:");
		        	  scanner.nextLine();
		        	  String tituloBuscado = scanner.nextLine();
		        	  if(tituloBuscado.isBlank()) {
		        		  System.out.println("No puede dejar el titulo vacio");
		        	  } else {
		        		  AudiovisualContent resultado = client.search(tituloBuscado);
		        		  System.out.println(resultado);
		        	  }
				} catch (IOException e) {
					System.out.println("Error de conexion");
				}
		          catch (PeliculaNoEncontradaException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Saliendo del programa......");
				break;
			default:
				break;
			}

        }while (key !=2);
        
        scanner.close();
    }
}
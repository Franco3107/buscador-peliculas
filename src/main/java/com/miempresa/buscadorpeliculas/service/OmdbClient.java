package com.miempresa.buscadorpeliculas.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.gson.Gson;
import com.miempresa.buscadorpeliculas.AudiovisualContent;
import com.miempresa.buscadorpeliculas.exception.PeliculaNoEncontradaException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class OmdbClient {

    private final String baseURL = "https://www.omdbapi.com/?t=PELICULA&apikey=API_KEY";
    private final String apiKey;

    public OmdbClient() {
        this.apiKey = loadApiKey();
    }
    
    
    public String buildURL(String titulo) {
    	String tituloCodificado = URLEncoder.encode(titulo, StandardCharsets.UTF_8);  // modifica el titulo para que no haya errores
        return this.baseURL.replace("PELICULA", tituloCodificado).replace("API_KEY", this.apiKey);
    }
	
	// Metodo para que Java vaya al URL y traiga el Json
	public String fetchData(String titulo) throws IOException {
	    String url = buildURL(titulo);
	    
	    OkHttpClient client = new OkHttpClient();  //creo al mensajero
	    Request request = new Request.Builder()  //creo el paquete y lo paso por el buildURL
	            .url(url)
	            .build();

	    Response response = client.newCall(request).execute();  //mando al msj a la url
	    return response.body().string();  
	}
	
	//Metodo que transforma el Json encontrado en una clase
	public AudiovisualContent search(String titulo) throws IOException, PeliculaNoEncontradaException {
	    String json = fetchData(titulo);
	    
	    Gson gson = new Gson();
	    AudiovisualContent contenido = gson.fromJson(json, AudiovisualContent.class);
	    if("False".equals(contenido.getResponse())) {
	    	throw new PeliculaNoEncontradaException("Pelicula no encontrada");
	    } else {
	    	return contenido;
	    }
	}
	private String loadApiKey() {
	    Properties properties = new Properties();  // creo el "diccionario" vacío
	    //clase propia de Java para leer archivos tipo clave=valor
	    
	    
	    try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
	        // abro el archivo config.properties como un flujo de datos
	        
	        if (input == null) {
	            throw new RuntimeException("No se encontró config.properties");
	            // si no lo encontró, corto todo con un error claro
	        }
	        
	        properties.load(input);
	        // le paso el flujo al diccionario, y él se encarga de leerlo e interpretarlo
	        
	        return properties.getProperty("omdb.apikey");
	        // le pido el valor de la clave "omdb.apikey", y lo devuelvo
	        
	    } catch (IOException e) {
	        throw new RuntimeException("Error al leer config.properties", e);
	        // si algo falla al leer (archivo corrupto, etc.), aviso con un error claro
	    }
	}
}

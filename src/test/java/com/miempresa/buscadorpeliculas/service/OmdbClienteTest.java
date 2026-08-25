package com.miempresa.buscadorpeliculas.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
 

class OmdbClienteTest {

	@Test
	void buildURLTest() {
		OmdbClient om = new OmdbClient();
		String titulo= "Lost";
		String url = om.buildURL(titulo);		
		assertTrue(url.contains("t=Lost"));
		assertTrue(url.contains("apikey="));
		assertFalse(url.endsWith("API_KEY"));
	}
	
	@Test
	// TODO: mejorar este test usando Mockito para simular la respuesta HTTP,
	// sin depender de una conexión real a internet ni gastar cuota de la API
	void fetchDataTest() throws IOException {
	    OmdbClient om = new OmdbClient();
	    String resultado = om.fetchData("Lost");

	    assertNotNull(resultado);
	    assertTrue(resultado.contains("Title"));
	}
	

}

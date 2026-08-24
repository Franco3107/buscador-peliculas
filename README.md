# Buscador de Películas y Series

Aplicación de consola en Java que consume la API de [OMDb](https://www.omdbapi.com/) para buscar información de películas y series: título, año, director, género, sinopsis, actores y rating de IMDb.

## Tecnologías

- Java
- Maven
- OkHttp (cliente HTTP)
- Gson (parseo de JSON)

## Cómo ejecutarlo

1. Cloná el repositorio
2. Conseguí una API key gratuita en [omdbapi.com/apikey.aspx](https://www.omdbapi.com/apikey.aspx)
3. Creá un archivo `src/main/resources/config.properties` con el siguiente contenido:

```
omdb.apikey=TU_API_KEY_ACA
```

4. Compilá y ejecutá el proyecto:

```
mvn clean package
java -jar target/buscador-peliculas-0.0.1-SNAPSHOT.jar
```

## Funcionalidades

- Búsqueda de películas y series por título
- Menú interactivo en consola (buscar / salir)
- Manejo de la API key mediante archivo de configuración externo (no incluido en el repositorio por seguridad)

## Estructura del proyecto

```
src/main/java/com/miempresa/buscadorpeliculas/
 ├── App.java                          → punto de entrada, menú interactivo
 ├── AudiovisualContent.java           → clase que representa una película/serie
 ├── enums/
 │    └── Type.java                    → tipo de contenido (movie/series)
 └── service/
      └── OmdbClient.java              → cliente que consume la API de OMDb
```

## Aprendizajes del proyecto

Este proyecto fue desarrollado como práctica de:
- Consumo de APIs REST desde Java
- Manejo de dependencias con Maven
- Serialización/deserialización de JSON con Gson
- Buenas prácticas de manejo de credenciales (variables de entorno / archivos de configuración excluidos del control de versiones)

## Posibles mejoras futuras

- Manejo de errores (título no encontrado, sin conexión)
- Persistencia de búsquedas favoritas en base de datos
- Tests unitarios con JUnit
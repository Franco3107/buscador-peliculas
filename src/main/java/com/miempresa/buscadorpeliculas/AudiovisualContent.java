package com.miempresa.buscadorpeliculas;


import com.google.gson.annotations.SerializedName;
import com.miempresa.buscadorpeliculas.enums.Type;
import com.miempresa.buscadorpeliculas.exception.PeliculaNoEncontradaException;

public class AudiovisualContent {
	@SerializedName("Title") // es un atributo para decirle a JSON que el atributo title lo va a encontrar de esa manera
    private String title;
    @SerializedName("Year")
    private String year;
    @SerializedName("Director")
    private String director;
    @SerializedName("Genre")
    private String genre;
    @SerializedName("Plot")
    private String plot;
    @SerializedName("Actors")
    private String actors;
    @SerializedName("Type")
    private Type type;
    @SerializedName("imdbRating")
    private String imdbRating;
    @SerializedName("Poster")
    private String poster;
    @SerializedName("Error")
    private String error;
    @SerializedName("Response")
    private String response;
	
	public AudiovisualContent(String title, String year, String director, String genre, String plot, String actors,
			Type type, String imdbRating, String poster, String error, String response) throws PeliculaNoEncontradaException {
		this.title = title;
		this.year = year;
		this.director = director;
		this.genre = genre;
		this.plot = plot;
		this.actors = actors;
		this.type = type;
		this.imdbRating = imdbRating;
		this.poster = poster;
		this.response=response;
	}
	
	// GETTER AND SETTER
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}

	//To String
	@Override
	public String toString() {
		return "AudiovisualContent [title=" + title + ", year=" + year + ", director=" + director + ", genre=" + genre
				+ ", plot=" + plot + ", actors=" + actors + ", type=" + type + ", imdbRating=" + imdbRating
				+ ", poster=" + poster + "]";
	}
	
	
	
	
	
}

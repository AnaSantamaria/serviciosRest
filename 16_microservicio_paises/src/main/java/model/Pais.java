package model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pais {
	@JsonAlias("name")
	private String nombre;
	private String capital;
	@JsonAlias("region")
	private String continente;
	@JsonAlias("population")
	private long poblacion; 
	@JsonAlias("flags")
	private String bandera;
	
	
	public Pais() {
		super();
	}


	public Pais(String nombre, String continente, String capital, long poblacion, String bandera) {
		super();
		this.nombre = nombre;
		this.continente = continente;
		this.capital = capital;
		this.poblacion = poblacion;
		this.bandera = bandera;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getContinente() {
		return continente;
	}


	public void setContinente(String continente) {
		this.continente = continente;
	}


	public String getCapital() {
		return capital;
	}


	public void setCapital(String capital) {
		this.capital = capital;
	}


	public long getPoblacion() {
		return poblacion;
	}


	public void setPoblacion(long poblacion) {
		this.poblacion = poblacion;
	}


	public String getBandera() {
		return bandera;
	}


	public void setBandera(String bandera) {
		this.bandera = bandera;
	}
	
	
	

}

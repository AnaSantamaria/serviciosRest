package model;

public class Respuesta {

	
	private String url;
	private String Tematica;
	private String descripcion;
	
	
	
	public Respuesta() {
		super();
	}



	public Respuesta(String url, String tematica, String descripcion) {
		super();
		this.url = url;
		Tematica = tematica;
		this.descripcion = descripcion;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getTematica() {
		return Tematica;
	}



	public void setTematica(String tematica) {
		Tematica = tematica;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}

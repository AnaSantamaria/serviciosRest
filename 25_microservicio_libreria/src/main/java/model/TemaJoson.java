package model;

public class TemaJoson {

	private int idTema;
	private String nombreTema;
	
	
	public TemaJoson() {
		super();
	}
	public TemaJoson(int idTema, String nombreTema) {
		super();
		this.idTema = idTema;
		this.nombreTema = nombreTema;
	}
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	public String getNombreTema() {
		return nombreTema;
	}
	public void setNombreTema(String nombreTema) {
		this.nombreTema = nombreTema;
	}
	
	
}

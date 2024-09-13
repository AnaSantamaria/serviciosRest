package model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class LibroJson {
	
	private String titulo;
	private double precio;
	private int paginas;
	@JsonAlias("temaDto")
	private TemaJoson temaJson;
	
	public LibroJson() {
		super();
	}

	public LibroJson(String titulo, double precio, int paginas, TemaJoson temaJson) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.paginas = paginas;
		this.temaJson = temaJson;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public TemaJoson getTemaJson() {
		return temaJson;
	}

	public void setTemaJson(TemaJoson temaJson) {
		this.temaJson = temaJson;
	}

	
	
	

}

package init.model;

import init.entities.Hotel;
import init.entities.Vuelo;

public class ReservasDto {
	
	private int idreserva;
	private Hotel hotel;
	private Vuelo vuelo;
	private double precio;
	private String usuario;
	
	public ReservasDto() {
		super();
	}

	public ReservasDto(int idreserva, Hotel hotel, Vuelo vuelo, double precio, String usuario) {
		super();
		this.idreserva = idreserva;
		this.hotel = hotel;
		this.vuelo = vuelo;
		this.precio = precio;
		this.usuario = usuario;
	}

	public int getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

	

	

}

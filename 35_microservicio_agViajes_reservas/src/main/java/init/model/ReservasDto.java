package init.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import init.entities.Hotel;
import init.entities.Vuelo;

public class ReservasDto {
	
	private int idreserva;
	@JsonProperty(value ="hotel")
	private HotelDto hotel;
	@JsonProperty(value="vuelo")
	private VuelosDto vuelo;
	private double precio;
	private String usuario;
	
	public ReservasDto() {
		super();
	}

	public ReservasDto(int idreserva, HotelDto hotel, VuelosDto vuelo, double precio, String usuario) {
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

	public HotelDto getHotel() {
		return hotel;
	}

	public void setHotel(HotelDto hotel) {
		this.hotel = hotel;
	}

	public VuelosDto getVuelo() {
		return vuelo;
	}

	public void setVuelo(VuelosDto vuelo) {
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

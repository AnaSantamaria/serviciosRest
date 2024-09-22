package init.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")

public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idreserva;
	private String nombre;
	private String dni;
	private int hotel;
	private int vuelo;
	private double precio;
	
	public Reserva() {
		super();
	}

	public Reserva(int idreserva, String nombre, String dni, int hotel, int vuelo, double precio) {
		super();
		this.idreserva = idreserva;
		this.nombre = nombre;
		this.dni = dni;
		this.hotel = hotel;
		this.vuelo = vuelo;
		this.precio = precio;
	}

	public int getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getHotel() {
		return hotel;
	}

	public void setHotel(int hotel) {
		this.hotel = hotel;
	}

	public int getVuelo() {
		return vuelo;
	}

	public void setVuelo(int vuelo) {
		this.vuelo = vuelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
		

}

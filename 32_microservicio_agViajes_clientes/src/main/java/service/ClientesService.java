package service;

import entities.Cliente;

public interface ClientesService {
	
	boolean registrar (Cliente cliente);
	
	Cliente loging (String usuario, String contraseña);
	
	Cliente buscar (String usuario);
	
}

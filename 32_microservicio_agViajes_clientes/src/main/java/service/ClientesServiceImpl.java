package service;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ClientesDao;
import entities.Cliente;

public class ClientesServiceImpl implements ClientesService {
	
	
	@Autowired
	ClientesDao clientesDao;

	@Override
	public boolean registrar(Cliente cliente) {
		
		if (clientesDao.findById(cliente.getUsuario()).isPresent()){
			
			return false;
		}
				clientesDao.save(cliente);
				
				return true;
		
		
	}

	@Override
	public Cliente loging(String usuario, String contraseña) {
		
		return clientesDao.findByUsuarioAndPassword(usuario, contraseña);
		
		
	}

	@Override
	public Cliente buscar(String usuario) {
		
		
		return clientesDao.findById(usuario).orElse(null);
	}

}

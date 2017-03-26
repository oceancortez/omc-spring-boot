/**
 * 
 */
package omc.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import omc.pedidos.entity.ClienteEntity;
import omc.pedidos.persistence.ClienteRepository;

/**
 * @author ocean
 *
 */
@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
//	public ClienteController(ClienteRepository repository) {
//		// TODO Auto-generated constructor stub
//		this.clienteRepository = repository;
//	}
	
	@GetMapping("/clientes")
	public List<ClienteEntity> getClientes(){
		return this.clienteRepository.findAll();
	}
	
	
	

}

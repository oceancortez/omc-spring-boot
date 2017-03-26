/**
 * 
 */
package omc.pedidos.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import omc.pedidos.entity.ClienteEntity;
import omc.pedidos.persistence.ClienteRepository;

/**
 * @author ocean
 *
 */
@Component
@Path("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
		
	@GET
	@Path("/clientes")
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<ClienteEntity> getClientes(){
		
		final List<ClienteEntity> clientes = this.clienteRepository.findAll();
		
		if(clientes.isEmpty()){
			return null;
		}
		
		return clientes;
	}
	
	@GET
	@Path("/cadastrar/{nome}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public String getClientes(@PathParam("nome") String nome){
		final ClienteEntity clienteSalvo = this.clienteRepository.saveAndFlush(new ClienteEntity(nome, null, null));
		return clienteSalvo.getCodigo().toString();
	}
	

}

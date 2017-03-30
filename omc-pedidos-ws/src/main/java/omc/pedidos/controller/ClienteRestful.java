/**
 * 
 */
package omc.pedidos.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import omc.pedidos.entity.ClienteEntity;
import omc.pedidos.persistence.ClienteDAO;

/**
 * @author ocean
 *
 */
@Component
@Path("/cliente")
public class ClienteRestful {
	
	@Autowired
	private ClienteDAO clienteDAO;
		
	@GET
	@Path("/listar-por")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true)
	public Response getClientes(@QueryParam("nome")String nome) throws JsonProcessingException{
		
		final List<ClienteEntity> clientes = this.clienteDAO.listPorNome(nome);
		
		if(CollectionUtils.isEmpty(clientes)){
			return Response.status(200).entity("Não foram encotrados registros com o nome = ".concat(nome)).build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String array = mapper.writeValueAsString(clientes);
		
		return Response.status(200).entity(array).build();
	}
	
	
	@GET
	@Path("/test")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getTest(){
		
		return Response.status(200).entity("TesteOK").build();
	}

}

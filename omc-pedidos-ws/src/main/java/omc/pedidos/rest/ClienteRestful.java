/**
 * 
 */
package omc.pedidos.rest;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

import omc.pedidos.business.service.IClienteBusiness;
import omc.pedidos.entity.ClienteEntity;

/**
 * @author ocean
 *
 */
@Component
@Path("/cliente")
public class ClienteRestful {
	
	@Autowired
	IClienteBusiness iClienteBusiness;
		
	@GET
	@Path("/listar-por")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true)
	public Response getClientesByName(@QueryParam("nome")String nome) throws JsonProcessingException{
		
		final List<ClienteEntity> clientes = this.iClienteBusiness.listPorNome(nome);
		
		if(CollectionUtils.isEmpty(clientes)){
			return Response.status(200).entity("Não foram encotrados registros com o nome = ".concat(nome)).build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String array = mapper.writeValueAsString(clientes);
		
		return Response.status(200).entity(array).build();
	}
	
	@GET
	@Path("/listar-clientes")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true)
	public Response getClientes() throws JsonProcessingException{
		
		final List<ClienteEntity> clientes = this.iClienteBusiness.listarClientes();
		
		if(CollectionUtils.isEmpty(clientes)){
			return Response.status(200).entity("Não foram encotrados registros").build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String array = mapper.writeValueAsString(clientes);
		
		return Response.status(200).entity(array).build();
	}
	
	
	@GET
	@Path("/test")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getTest(){
		System.out.println("Entou no método getTest as ".concat(new Date().toString()));
		return Response.status(200).entity("TesteOK").build();
	}
	
	@POST
	@Path("/cadastrar")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response cadastar(String cliente) throws JsonProcessingException{
		
		ClienteEntity clienteEntity = this.iClienteBusiness.cadastrarCliente(cliente);
		
		if(clienteEntity == null){
			return Response.status(200).entity("Não foi possível fazer o  cadastro = ").build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String retorno = mapper.writeValueAsString(clienteEntity);
		
		return Response.status(200).entity(retorno).build();
	}

}

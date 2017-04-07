/**
 * 
 */
package omc.pedidos.controller;

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

import omc.pedidos.business.IPedidoBusiness;
import omc.pedidos.business.type.PedidoType;
import omc.pedidos.entity.ClienteEntity;

/**
 * @author ocean
 *
 */
@Component
@Path("/pedido")
public class PedidoRestful {
	
	@Autowired
	IPedidoBusiness iPedidoBusiness;
		
	@GET
	@Path("/listar-por")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true)
	public Response getClientesByName(@QueryParam("nome")String nome) throws JsonProcessingException{
		
		final List<PedidoType> pedidos = this.iPedidoBusiness.listPorNome(nome);
		
		if(CollectionUtils.isEmpty(pedidos)){
			return Response.status(200).entity("Não foram encotrados registros com o nome = ".concat(nome)).build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String array = mapper.writeValueAsString(pedidos);
		
		return Response.status(200).entity(array).build();
	}
	
	@GET
	@Path("/listar-pedidos")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true)
	public Response getClientes() throws JsonProcessingException{
		
		final List<PedidoType> pedidos = this.iPedidoBusiness.listarPedidos();
		
		if(CollectionUtils.isEmpty(pedidos)){
			return Response.status(200).entity("Não foram encotrados registros").build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String array = mapper.writeValueAsString(pedidos);
		
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
		
		PedidoType pedido = this.iPedidoBusiness.cadastrarPedido(cliente);
		
		if(pedido == null){
			return Response.status(200).entity("Não foi possível fazer o  cadastro = ").build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String retorno = mapper.writeValueAsString(pedido);
		
		return Response.status(200).entity(retorno).build();
	}

}

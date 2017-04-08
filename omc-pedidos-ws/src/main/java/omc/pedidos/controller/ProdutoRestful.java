/**
 * 
 */
package omc.pedidos.controller;

import java.util.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import omc.pedidos.business.service.IProdutoBusiness;
import omc.pedidos.business.type.ProdutoType;

/**
 * @author ocean
 *
 */
@Component
@Path("/produto")
public class ProdutoRestful {
	
	@Autowired
	IProdutoBusiness produtoBusiness;
		
	@GET
	@Path("/listar-por")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true)
	public Response getProdutosByName(@QueryParam("nome")String nome) throws JsonProcessingException{
		
		final List<ProdutoType> produtos = this.produtoBusiness.listPorNome(nome);
		
		if(CollectionUtils.isEmpty(produtos)){
			return Response.status(200).entity("Não foram encotrados registros com o nome = ".concat(nome)).build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String array = mapper.writeValueAsString(produtos);
		
		return Response.status(200).entity(array).build();
	}
	
	@GET
	@Path("/listar-produtos")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true)
	public Response getProdutos() throws JsonProcessingException{
		
		final List<ProdutoType> produtos = this.produtoBusiness.listarProdutos();
		
		if(CollectionUtils.isEmpty(produtos)){
			return Response.status(200).entity("Não foram encotrados registros").build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String array = mapper.writeValueAsString(produtos);
		
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
	public Response cadastar(String produtosJson) throws JsonProcessingException{
		
		String produto = this.produtoBusiness.cadastrarProduto(produtosJson);
		
		if(StringUtils.isEmpty(produto)){
			return Response.status(200).entity("Não foi possível fazer o  cadastro = ").build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String retorno = mapper.writeValueAsString(produto);
		
		return Response.status(200).entity(retorno).build();
	}
	
	@PUT
	@Path("/atualizar")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response atualizar(String produtosJson) throws JsonProcessingException{
		
		ProdutoType produto = this.produtoBusiness.atualizarProduto(produtosJson);
		
		if(produto == null){
			return Response.status(200).entity("Não foi possível fazer o  cadastro = ").build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String retorno = mapper.writeValueAsString(produto);
		
		return Response.status(200).entity(retorno).build();
	}
	
	@DELETE
	@Path("/deletar")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response deletar(String produtosJson) throws JsonProcessingException{
		
		String produto = this.produtoBusiness.excluirProduto(produtosJson);
		
		if(produto == null){
			return Response.status(200).entity("Não foi possível fazer o  cadastro = ").build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String retorno = mapper.writeValueAsString(produto);
		
		return Response.status(200).entity(retorno).build();
	}

}

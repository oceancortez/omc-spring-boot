/**
 * 
 */
package omc.pedidos.rest;

import java.util.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
import omc.pedidos.business.service.IProductBusiness;
import omc.pedidos.business.type.ProductType;

/**
 * @author ocean
 *
 */
@Component
@Path("/product")
public class ProductRestful {
	
	@Autowired
	IProductBusiness productBusiness;
		
	@GET
	@Path("/list-by")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true)
	public Response getProductsByName(@QueryParam("nome")String name) throws JsonProcessingException{
		
		final List<ProductType> productTypes = this.productBusiness.listByName(name);
		
		if(CollectionUtils.isEmpty(productTypes)){
			return Response.status(200).entity("Não foram encotrados registros com o nome = ".concat(name)).build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String array = mapper.writeValueAsString(productTypes);
		
		return Response.status(200).entity(array).build();
	}
	
	@GET
	@Path("/list-by-category")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true)
	public Response getProductsByCategoryId(@QueryParam("categoryId")Long categoryId) throws JsonProcessingException{
		
		final List<ProductType> productTypes = this.productBusiness.listProductsByCategoryId(categoryId);
		
		if(CollectionUtils.isEmpty(productTypes)){
			return Response.status(200).entity("Não foram encotrados registros com o nome = ".concat(categoryId.toString())).build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String array = mapper.writeValueAsString(productTypes);
		
		return Response.status(200).entity(array).build();
	}
	
	@GET
	@Path("/list-products")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true)
	public Response getProducts() throws JsonProcessingException{
		
		final List<ProductType> productTypes = this.productBusiness.listProducts();
		
		if(CollectionUtils.isEmpty(productTypes)){
			return Response.status(200).entity("Não foram encotrados registros").build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String array = mapper.writeValueAsString(productTypes);
		
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
	@Path("/create")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response create(String produtosJson) throws JsonProcessingException{
		
		String product = this.productBusiness.createProduct(produtosJson);		
		
		if(product.isEmpty()){
			return Response.status(200).entity("Não foi possível fazer o  cadastro = ").build();
		}				
		return Response.status(200).entity(product).build();
	}
	
	@PUT
	@Path("/update")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response update(String productJson) throws JsonProcessingException{
		
		String productType = this.productBusiness.updateProduct(productJson);
		
		if(productType.isEmpty()){
			return Response.status(200).entity("Não foi possível fazer o  cadastro = ").build();
		}
				
		return Response.status(200).entity(productType).build();
	}
	
	@DELETE
	@Path("/delete")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response delete(@QueryParam("productId") String productId) throws JsonProcessingException{
		
		String product = this.productBusiness.deleteProduct(productId);
		
		if(product.isEmpty()){
			return Response.status(200).entity("Não foi possível fazer o  cadastro = ").build();
		}
				
		return Response.status(200).entity(product).build();
	}

}

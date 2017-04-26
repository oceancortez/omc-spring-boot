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
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import omc.pedidos.business.service.IProductBusiness;
import omc.pedidos.business.type.ProductResponse;
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
	public ResponseEntity<ProductResponse> getProductsByCategoryId(@QueryParam("categoryId")Long categoryId) throws JsonProcessingException{
				
		return ResponseEntity.status(200).body(this.productBusiness.listProductsByCategoryId(categoryId));
	}
	
	@GET
	@Path("/list-products")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true)
	public ResponseEntity<ProductResponse> getProducts() throws JsonProcessingException{
			
		return ResponseEntity.status(200).body(this.productBusiness.listProducts());
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
	public ResponseEntity<ProductResponse> create(String productJson) throws JsonProcessingException{
						
		return  ResponseEntity.status(200).body(this.productBusiness.createProduct(productJson));
	}
	
	@PUT
	@Path("/update")
	@Produces(value = MediaType.APPLICATION_JSON)
	public ResponseEntity<ProductResponse> update(String productJson) throws JsonProcessingException{
		
		return  ResponseEntity.status(200).body(this.productBusiness.updateProduct(productJson));
	}
	
	@DELETE
	@Path("/delete")
	@Produces(value = MediaType.APPLICATION_JSON)
	public ResponseEntity<ProductResponse> delete(@QueryParam("productId") String productId) throws JsonProcessingException{
		
		return  ResponseEntity.status(200).body(this.productBusiness.deleteProduct(productId));
	}

}

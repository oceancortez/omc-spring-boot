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

import omc.pedidos.business.service.ICategoryBusiness;
import omc.pedidos.business.type.CategoryResponse;
import omc.pedidos.business.type.CategoryType;

/**
 * @author ocean
 *
 */
@Component
@Path("/category")
public class CategoryRestful {
	
	@Autowired
	ICategoryBusiness categoryBusiness;
		
	@GET
	@Path("/list-by")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true)
	public Response getCategoriesByName(@QueryParam("nome")String name) throws JsonProcessingException{
		
		final List<CategoryType> categoryTypes = this.categoryBusiness.listByName(name);
		
		if(CollectionUtils.isEmpty(categoryTypes)){
			return Response.status(200).entity("Não foram encotrados registros com o nome = ".concat(name)).build();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String array = mapper.writeValueAsString(categoryTypes);
		
		return Response.status(200).entity(array).build();
	}

	
	@GET
	@Path("/list-categories")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Transactional(readOnly = true)
	public ResponseEntity<CategoryResponse> getCategories() throws JsonProcessingException{
		
		return ResponseEntity.status(200).body(this.categoryBusiness.listCategories());
	}
	
	
	@GET
	@Path("/test")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getTest(){
		System.out.println("Entou no método getTest as category".concat(new Date().toString()));
		return Response.status(200).entity("TesteOK").build();
	}
	
	@POST
	@Path("/create")
	@Produces(value = MediaType.APPLICATION_JSON)
	public ResponseEntity<CategoryResponse> create(String productJson) throws JsonProcessingException{
					
		return ResponseEntity.status(200).body(categoryBusiness.create(productJson));
	}
	
	@PUT
	@Path("/update")
	@Produces(value = MediaType.APPLICATION_JSON)
	public ResponseEntity<CategoryResponse> update(String productJson) throws JsonProcessingException{
		
		return ResponseEntity.status(200).body(categoryBusiness.update(productJson));
	}
	
	@DELETE
	@Path("/delete")
	@Produces(value = MediaType.APPLICATION_JSON)
	public ResponseEntity<CategoryResponse> delete(@QueryParam("productId") String productId) throws JsonProcessingException{
		
		return ResponseEntity.status(200).body(categoryBusiness.delete(productId));
	}

}

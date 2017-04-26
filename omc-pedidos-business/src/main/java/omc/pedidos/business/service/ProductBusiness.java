package omc.pedidos.business.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.transaction.TransactionRequiredException;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import omc.pedidos.business.type.ProductResponse;
import omc.pedidos.business.type.ProductType;
import omc.pedidos.business.util.ParseUtil;
import omc.pedidos.entity.ProductEntity;
import omc.pedidos.persistence.ICategoryDAO;
import omc.pedidos.persistence.IProductDAO;

/**
 * @author 579535
 *
 */
@Component
public class ProductBusiness implements IProductBusiness {

	private static final Logger log = LoggerFactory.getLogger(ProductBusiness.class);

	@Autowired
	private IProductDAO productDAO;
	
	@Autowired
	private ICategoryDAO categoryDAO;

	@Override
	public List<ProductType> listByName(final String name) {
		return ParseUtil.parseListProductEntityToType(productDAO.listByName(name));
	}

	@Override
	public ProductResponse createProduct(final String cliente) {
		ProductResponse productResponse = new ProductResponse();
		ProductEntity productEntity = new ProductEntity();
		ProductType productType = null;		
	
		try {
			productType = (ProductType) ParseUtil.parseJsonToType(cliente, new ProductType());
		} catch (IOException e1) {
			e1.printStackTrace();
			return new ProductResponse("Erro de dado Inválido, favor analisar os dados digitados!");
		}
		
		productEntity = ParseUtil.parseProdutoTypeToEntity(productType);

		try {
			productEntity.setCategoryEntity(categoryDAO.findById(productType.getCategoryId()));
			productEntity = productDAO.persist(productEntity);
			productEntity = productDAO.findById(productEntity.getCodigo());
			
			if (productEntity.getCodigo() != null) {
				productResponse.setProductType(productType);
				productResponse.setMessage("The Product ".concat(productEntity.getNome().concat(" was created with Success!")));
				log.info(productResponse.getMessage());
			}else{
				productResponse.setMessage("Error! The Product ".concat(productEntity.getNome().concat(" note was created!")));
			}
			
		} catch (EntityExistsException | TransactionRequiredException | IllegalStateException
				| IllegalArgumentException e) {
			log.error(e.getMessage());
				productResponse.setMessage("Error! The Product ".concat(e.getMessage()));
		} catch (Exception e) {
			if (e.getCause().getCause().getMessage().contains("NOMPRD_UNIQUE")) {
				String retorno = "Please create other Product, this Product has been existes with name!";
				productResponse.setMessage("Error! The Product ".concat(retorno));
				log.info(productResponse.getMessage());
			}else{
				productResponse.setMessage("Error! The Product ".concat(e.getMessage()));
			}
		}

		return productResponse;
	}

	@Override
	public ProductResponse updateProduct(final String cliente) {
		ProductResponse response = new ProductResponse();
		ProductEntity productEntity = new ProductEntity();
		ProductType productType = null;
		
		try {
			productType = (ProductType) ParseUtil.parseJsonToType(cliente, new ProductType());
		} catch (IOException e1) {
			e1.printStackTrace();
			return new ProductResponse("Erro de dado Inválido, favor analisar os dados digitados!");
		}
		productEntity = ParseUtil.parseProdutoTypeToEntity(productType);

		try {
			productEntity.setCategoryEntity(categoryDAO.getCategoryByProductId(productEntity.getCodigo()));
			productEntity = productDAO.update(productEntity);
			response.setProductType(productType);
			response.setMessage("The Product ".concat(productEntity.getNome().concat(" was refresh with Success!")));			
			log.info(response.getMessage());
			
		} catch (TransactionRequiredException | IllegalStateException | IllegalArgumentException e1) {
			log.error(e1.getMessage());
		} catch (Exception e) {
			if (e.getCause().getCause().getMessage().contains("NOMPRD_UNIQUE")) {
				String retorno = "Please create other Product, this Product has been existes with name!";
				response.setMessage("Error! The Product ".concat(retorno));
				log.info(response.getMessage());
			}else{
				response.setMessage("Error! The Product ".concat(e.getMessage()));
			}
		}

		return response;
	}

	@Override
	public ProductResponse listProducts() {
		ProductResponse productResponse = new ProductResponse();
		
		try {
			List<ProductEntity> productEntities = productDAO.findAll();
			if(CollectionUtils.isNotEmpty(productEntities)){
				List<ProductType> parseTypes = ParseUtil.parseListProductEntityToType(productEntities);
				productResponse.setProductTypes(parseTypes);
			}else{
				productResponse.setMessage("Não foram encotrados registros");
			}			
			
		} catch (Exception e) {
			productResponse.setMessage(e.getMessage());			
		}				
		return productResponse;
	}

	@Override
	public ProductResponse deleteProduct(String produtosJson) {
		ProductResponse response = new ProductResponse();		
		ProductEntity productEntity; 								

		productEntity = productDAO.findById(new Long(produtosJson));
		if (CollectionUtils.isNotEmpty(productEntity.getPedidoEntities())) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < productEntity.getPedidoEntities().size(); i++) {				
				builder.append("\n REJECT \n");
				builder.append(
						"O produto não pode ser excluído, pois ainda está sendo utilizado pelos pedidos abaixo: ");
				builder.append("\n")
						.append(productEntity.getPedidoEntities().get(i).getId().getCodigoPedido().toString());
				builder.append("\n").append(productEntity.getPedidoEntities().get(i).getNome().toString());
				break;	
		
			}
			response.setProductType(ParseUtil.parseProdutoEntityType(productEntity));
			response.setMessage(builder.toString());
			log.info(response.getMessage());
			return response;		
		}	

		try {
			productDAO.delete(productEntity);
			response.setMessage("{The Product ".concat(productEntity.getNome().concat(" was deleted with Success!}")));
			log.info(response.getMessage());
			
		} catch (TransactionRequiredException | IllegalStateException | IllegalArgumentException
				| PersistenceException e) {			
			response.setMessage(e.getMessage());
			log.error(e.getMessage());
		} catch (Exception e) {			
			response.setMessage("Não foi possível exlcuir o registro ".concat(productEntity.getNome()));
			log.error(e.getMessage());
		}

		return response;
	}
	
	@Override
	public ProductResponse listProductsByCategoryId(final Long categoryId) {
		ProductResponse productResponse = new ProductResponse();
		
		try {
			List<ProductEntity> productEntities = productDAO.listProductsByCategoryId(categoryId);
			if(CollectionUtils.isNotEmpty(productEntities)){
				List<ProductType> parseTypes = ParseUtil.parseListProductEntityToType(productEntities);
				productResponse.setProductTypes(parseTypes);
			}else{
				productResponse.setMessage("Não foram encotrados produtos para esta Categoria!");
			}			
			
		} catch (Exception e) {
			productResponse.setMessage(e.getMessage());			
		}		
		
		return productResponse;
	}

}

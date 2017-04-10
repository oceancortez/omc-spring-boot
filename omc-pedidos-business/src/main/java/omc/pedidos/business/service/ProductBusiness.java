package omc.pedidos.business.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.transaction.TransactionRequiredException;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import omc.pedidos.business.type.ProductType;
import omc.pedidos.business.util.ParseUtil;
import omc.pedidos.entity.ProductEntity;
import omc.pedidos.persistence.IProductDAO;

/**
 * @author 579535
 *
 */
@Component
public class ProductBusiness implements IProductBusiness {

	@Autowired
	private IProductDAO productDAO;

	@Override
	public List<ProductType> listByName(final String name) {
		return ParseUtil.parseListProductEntityToType(productDAO.listByName(name));
	}

	@Override
	public String createProduct(final String cliente) {
		String retorno = "";
		ProductEntity productEntity = new ProductEntity();
		ProductType productType = null;

		productType = (ProductType) ParseUtil.parseJsonToType(cliente, new ProductType());
		productEntity = ParseUtil.parseProdutoTypeToEntity(productType);
		
		
		try {
			productEntity = productDAO.persist(productEntity);
			productEntity = productDAO.findById(productEntity.getCodigo());
			if (productEntity.getCodigo() != null) {
				retorno = "Produto ".concat(productEntity.getNome().concat(" foi cadastrado com Sucesso!"));
			}
		} catch (EntityExistsException | TransactionRequiredException | IllegalStateException
				| IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			if (e.getCause().getCause() instanceof MySQLIntegrityConstraintViolationException) {
				retorno = "Favor cadastrar outro produto, pois já exite um produto com esse nome!";
			}
		}
		
		return retorno;
	}

	@Override
	public ProductType updateProduct(final String cliente) {
		ProductEntity productEntity = new ProductEntity();
		ProductType productType = null;

		productType = (ProductType) ParseUtil.parseJsonToType(cliente, new ProductType());
		productEntity = ParseUtil.parseProdutoTypeToEntity(productType);

		try {
			productType = ParseUtil.parseProdutoEntityType(productEntity);
			productEntity = productDAO.update(productEntity);
		} catch (TransactionRequiredException | IllegalStateException | IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();	
		
		}
		


		return productType;
	}

	@Override
	public List<ProductType> listProducts() {
		List<ProductEntity> productEntities = productDAO.findAll();
		List<ProductType> produtos = ParseUtil.parseListProductEntityToType(productEntities);
		return produtos;
	}

	@Override
	public String deleteProduct(String produtosJson) {
		String retorno = "";
		ProductType productType = (ProductType) ParseUtil.parseJsonToType(produtosJson, new ProductType());
		ProductEntity productEntity = ParseUtil.parseProdutoTypeToEntity(productType);

		productEntity = productDAO.findById(productEntity.getCodigo());
		if (CollectionUtils.isNotEmpty(productEntity.getPedidoEntities())) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < productEntity.getPedidoEntities().size(); i++) {
				builder.append("O produto não pode ser excluído, pois ainda está sendo utilizado pelos pedidos abaixo: ");
				builder.append("\n").append(productEntity.getPedidoEntities().get(i).getId().getCodigoPedido().toString());
				builder.append("\n").append(productEntity.getPedidoEntities().get(i).getNome().toString());
			}
			retorno = builder.toString();
			
			return retorno;	
		}
		
		try {
			productDAO.delete(productEntity);
			retorno = "{O produto ".concat(productType.getNome().concat(" foi excluído com Sucesso!}"));
		} catch (TransactionRequiredException | IllegalStateException | IllegalArgumentException
				| PersistenceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			retorno = "Não foi possível exlcuir o registro ".concat(productType.getNome());
			e.printStackTrace();
		}			

		return retorno;
	}

}

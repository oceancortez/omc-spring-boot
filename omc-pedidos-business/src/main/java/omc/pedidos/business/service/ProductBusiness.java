package omc.pedidos.business.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.transaction.TransactionRequiredException;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger log = LoggerFactory.getLogger(ProductBusiness.class);

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
				retorno = "The Product ".concat(productEntity.getNome().concat(" was created with Success!"));
				log.info(retorno);
			}
		} catch (EntityExistsException | TransactionRequiredException | IllegalStateException
				| IllegalArgumentException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			if (e.getCause().getCause() instanceof MySQLIntegrityConstraintViolationException) {
				retorno = "Please create other Product, this Product has been existes with name!";
				log.info(retorno);
			}
		}

		return ParseUtil.parseStringToJson(retorno);
	}

	@Override
	public String updateProduct(final String cliente) {
		String retorno = "";
		ProductEntity productEntity = new ProductEntity();
		ProductType productType = null;

		productType = (ProductType) ParseUtil.parseJsonToType(cliente, new ProductType());
		productEntity = ParseUtil.parseProdutoTypeToEntity(productType);

		try {
			productEntity = productDAO.update(productEntity);
			retorno = "The Product ".concat(productEntity.getNome().concat(" was refresh with Success!"));
			log.info("The product ".concat(productEntity.getNome()).concat(" was refresh with Success!"));
		} catch (TransactionRequiredException | IllegalStateException | IllegalArgumentException e1) {
			log.error(e1.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			if (e.getCause().getCause().getCause() instanceof MySQLIntegrityConstraintViolationException) {
				retorno = "Please update with other name of Product, this Product has been existes!";
				log.info(retorno);
			}
		}

		return ParseUtil.parseStringToJson(retorno);
	}

	@Override
	public List<ProductType> listProducts() {
		List<ProductEntity> productEntities = productDAO.findAll();
		log.info("Qtde of Products = " + String.valueOf(productEntities.size()));
		List<ProductType> produtos = ParseUtil.parseListProductEntityToType(productEntities);
		return produtos;
	}

	@Override
	public String deleteProduct(String produtosJson) {
		String retorno = "";
		// ProductType productType = (ProductType)
		// ParseUtil.parseJsonToType(produtosJson, new ProductType());
		ProductEntity productEntity; // =
										// ParseUtil.parseProdutoTypeToEntity(productType);

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
			}
			retorno = builder.toString();
			log.info(retorno);

			return retorno;
		}

		try {
			productDAO.delete(productEntity);
			retorno = "{The Product ".concat(productEntity.getNome().concat(" was deleted with Success!}"));
			log.info(retorno);
		} catch (TransactionRequiredException | IllegalStateException | IllegalArgumentException
				| PersistenceException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			retorno = "Não foi possível exlcuir o registro ".concat(productEntity.getNome());
			log.error(retorno);
			log.error(e.getMessage());
		}

		return ParseUtil.parseStringToJson(retorno);
	}

}

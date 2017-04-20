package omc.pedidos.business.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.transaction.TransactionRequiredException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import omc.pedidos.business.type.CategoryType;
import omc.pedidos.business.util.ParseUtil;
import omc.pedidos.entity.CategoryEntity;
import omc.pedidos.persistence.ICategoryDAO;

/**
 * @author 579535
 *
 */
@Component
public class CategoryBusiness implements ICategoryBusiness {

	private static final Logger log = LoggerFactory.getLogger(CategoryBusiness.class);

	@Autowired
	private ICategoryDAO categoryDAO;

	@Override
	public List<CategoryType> listByName(final String name) {
		return ParseUtil.parseListCategoryEntityToType(categoryDAO.listByName(name));
	}

	@Override
	public String create(final String cliente) {
		String retorno = "";
		CategoryEntity categoryEntity = new CategoryEntity();
		CategoryType categoryType = null;

		categoryType = (CategoryType) ParseUtil.parseJsonToType(cliente, new CategoryType());
		categoryEntity = ParseUtil.parseCategoryTypeToEntity(categoryType);

		try {
			categoryEntity = categoryDAO.persist(categoryEntity);
			categoryEntity = categoryDAO.findById(categoryEntity.getId());
			if (categoryEntity.getId() != null) {
				retorno = "The Category '".concat(categoryEntity.getName().concat("' was created with Success!"));
				log.info(retorno);
			}
		} catch (EntityExistsException | TransactionRequiredException | IllegalStateException
				| IllegalArgumentException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			if (e.getCause().getCause() instanceof MySQLIntegrityConstraintViolationException) {
				retorno = "Please create other Category, this Category has been existes with name!";
				log.info(retorno);
			}
		}

		return ParseUtil.parseStringToJson(retorno);
	}

	@Override
	public String update(final String cliente) {
		String retorno = "";
		CategoryEntity categoryEntity = new CategoryEntity();
		CategoryType categoryType = null;

		categoryType = (CategoryType) ParseUtil.parseJsonToType(cliente, new CategoryType());
		categoryEntity = ParseUtil.parseCategoryTypeToEntity(categoryType);

		try {
			categoryEntity = categoryDAO.update(categoryEntity);
			retorno = "The Category ".concat(categoryEntity.getName().concat(" was refresh with Success!"));
			log.info("The Category ".concat(categoryEntity.getName()).concat(" was refresh with Success!"));
		} catch (TransactionRequiredException | IllegalStateException | IllegalArgumentException e1) {
			log.error(e1.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			if (e.getCause().getCause().getCause() instanceof MySQLIntegrityConstraintViolationException) {
				retorno = "Please update with other name of Category, this Category has been existes!";
				log.info(retorno);
			}
		}

		return ParseUtil.parseStringToJson(retorno);
	}

	@Override
	public List<CategoryType> listCategories() {
		List<CategoryEntity> categoryEntities = categoryDAO.findAll();
		log.info("Qtde of categoryEntities = " + String.valueOf(categoryEntities.size()));
		List<CategoryType> categories = ParseUtil.parseListCategoryEntityToType(categoryEntities);
		return categories;
	}

	@Override
	public String delete(String produtosJson) {
		String retorno = "";
		// ProductType productType = (ProductType)
		// ParseUtil.parseJsonToType(produtosJson, new ProductType());
		CategoryEntity categoryEntity; // =
										// ParseUtil.parseProdutoTypeToEntity(productType);

		categoryEntity = categoryDAO.findById(new Long(produtosJson));
//		if (CollectionUtils.isNotEmpty(categoryEntity.getPedidoEntities())) {
//			StringBuilder builder = new StringBuilder();
//			for (int i = 0; i < categoryEntity.getPedidoEntities().size(); i++) {
//				builder.append("\n REJECT \n");
//				builder.append(
//						"O produto não pode ser excluído, pois ainda está sendo utilizado pelos pedidos abaixo: ");
//				builder.append("\n")
//						.append(categoryEntity.getPedidoEntities().get(i).getId().getCodigoPedido().toString());
//				builder.append("\n").append(categoryEntity.getPedidoEntities().get(i).getNome().toString());
//			}
//			retorno = builder.toString();
//			log.info(retorno);
//
//			return retorno;
//		}

		try {
			categoryDAO.delete(categoryEntity);
			retorno = "{The Category ".concat(categoryEntity.getName().concat(" was deleted with Success!}"));
			log.info(retorno);
		} catch (TransactionRequiredException | IllegalStateException | IllegalArgumentException
				| PersistenceException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			retorno = "Não foi possível exlcuir o registro ".concat(categoryEntity.getName());
			log.error(retorno);
			log.error(e.getMessage());
		}

		return ParseUtil.parseStringToJson(retorno);
	}

}

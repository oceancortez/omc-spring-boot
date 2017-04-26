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

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import omc.pedidos.business.type.CategoryResponse;
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
	public CategoryResponse create(final String cliente) {
		CategoryResponse response = new CategoryResponse();		
		CategoryEntity categoryEntity = new CategoryEntity();
		CategoryType categoryType = null;

		try {
			categoryType = (CategoryType) ParseUtil.parseJsonToType(cliente, new CategoryType());
		} catch (IOException e1) {
			response.setMessage(e1.getMessage());
			return response;
		}
		categoryEntity = ParseUtil.parseCategoryTypeToEntity(categoryType);

		try {
			categoryEntity = categoryDAO.persist(categoryEntity);
			categoryEntity = categoryDAO.findById(categoryEntity.getId());
			if (categoryEntity.getId() != null) {
				response.setMessage("The Category '".concat(categoryEntity.getName().concat("' was created with Success!")));
				response.setCategoryType(categoryType);
				log.info(response.getMessage());
			}else{
				response.setMessage("The Category '".concat(categoryType.getName().concat("' Don't Possible was created!")));
			}
			
		} catch (EntityExistsException | TransactionRequiredException | IllegalStateException
				| IllegalArgumentException e) {
			response.setMessage(e.getMessage());

		} catch (Exception e) {
			if (e.getCause().getCause().getMessage().contains("NAMCAT")) {
				String message = "Please create other Category, this Category has been existes with name!";
				response.setMessage("Error! The Category ".concat(message));
				log.info(response.getMessage());
			}else{
				response.setMessage("Error! The Category ".concat(e.getMessage()));
			}
		}

		return response;
	}

	@Override
	public CategoryResponse update(final String cliente) {
		CategoryResponse response = new CategoryResponse();
		String retorno = "";
		CategoryEntity categoryEntity = new CategoryEntity();
		CategoryType categoryType = null;

		try {
			categoryType = (CategoryType) ParseUtil.parseJsonToType(cliente, new CategoryType());
		} catch (IOException e1) {
			response.setMessage(e1.getMessage());
			return response;
		}
		categoryEntity = ParseUtil.parseCategoryTypeToEntity(categoryType);

		try {
			categoryEntity = categoryDAO.update(categoryEntity);			
			response.setMessage("The Category '".concat(categoryEntity.getName().concat("' was refresh with Success!")));
			response.setCategoryType(categoryType);
			log.info(response.getMessage());
		} catch (TransactionRequiredException | IllegalStateException | IllegalArgumentException e1) {
			response.setMessage(e1.getMessage());
			log.error(e1.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			if (e.getCause().getCause().getMessage().contains("NOMPRD_UNIQUE")) {
				String message = "Please create other Category, this Category has been existes with name!";
				response.setMessage("Error! The Category ".concat(message));
				log.info(response.getMessage());
			}else{
				response.setMessage("Error! The Category ".concat(e.getMessage()));
			}
		}

		return response;
	}

	@Override
	public CategoryResponse listCategories() {
		CategoryResponse response = new CategoryResponse();		
		List<CategoryEntity> categoryEntities = categoryDAO.findAll();
		log.info("Qtde of categoryEntities = " + String.valueOf(categoryEntities.size()));
		if(CollectionUtils.isEmpty(categoryEntities)){
			response.setMessage("Não exitem registros na base!");
			return response;
		}
		response.setCategoryTypes(ParseUtil.parseListCategoryEntityToType(categoryEntities));
		return response;
	}

	@Override
	public CategoryResponse delete(String produtosJson) {
		CategoryResponse response = new CategoryResponse();
		CategoryEntity categoryEntity; 										

		categoryEntity = categoryDAO.findById(new Long(produtosJson));
		
		if (CollectionUtils.isNotEmpty(categoryEntity.getProductEntities())) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < categoryEntity.getProductEntities().size();) {
				builder.append("\n REJECT \n");
				builder.append(
						"O Category não pode ser excluído, pois ainda está sendo utilizado pelos pedidos abaixo: ");
				builder.append("\n")
						.append(categoryEntity.getProductEntities().iterator().next().getCodigo().toString());
				builder.append("\n").append(categoryEntity.getProductEntities().iterator().next().getNome().toString());
				break;	
		
			}
			response.setCategoryType(ParseUtil.parseCategoryEntityToType(categoryEntity));
			response.setMessage(builder.toString());
			log.info(response.getMessage());
			return response;
		}

		try {
			categoryDAO.delete(categoryEntity);
			response.setMessage("{The Category ".concat(categoryEntity.getName().concat(" was deleted with Success!}")));
			log.info(response.getMessage());
		} catch (TransactionRequiredException | IllegalStateException | IllegalArgumentException
				| PersistenceException e) {
			response.setMessage(e.getMessage());
			log.error(e.getMessage());
		} catch (Exception e) {
			response.setMessage("Não foi possível exlcuir o registro ".concat(categoryEntity.getName()));
			log.error(e.getMessage());
		}

		return response;
	}

}

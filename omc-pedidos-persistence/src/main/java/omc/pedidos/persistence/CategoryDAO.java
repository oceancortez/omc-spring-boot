/**
 * 
 */
package omc.pedidos.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import omc.pedidos.entity.CategoryEntity;
import omc.pedidos.entity.ProductEntity;

/**
 * @author ocean
 *
 */
@Repository
public class CategoryDAO extends GenericDAO<CategoryEntity, Long> implements ICategoryDAO  {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryDAO.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<CategoryEntity> listByName(String nome) {
		 TypedQuery<CategoryEntity> createQuery = 
				 this.entityManager.createQuery("SELECT c FROM CategoryEntity c WHERE c.nome LIKE CONCAT('%',:nome,'%')", CategoryEntity.class);
		 createQuery.setParameter("nome", nome);
		
		List<CategoryEntity> categoryPorNome = createQuery.getResultList();
		
		return categoryPorNome;
	}

	@Override
	public CategoryEntity getCategoryByProductId(Long categoryId) {
		final Query namedQuery = this.entityManager.createNamedQuery("CategoryEntity.getCategoryByProductId");

		 namedQuery.setParameter("categoryId", categoryId);

		 CategoryEntity categoryEntity = (CategoryEntity) namedQuery.getSingleResult();
		
		return categoryEntity;
	}

}

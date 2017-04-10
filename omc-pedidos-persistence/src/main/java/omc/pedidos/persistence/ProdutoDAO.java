/**
 * 
 */
package omc.pedidos.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import omc.pedidos.entity.ProductEntity;

/**
 * @author ocean
 *
 */
@Repository
public class ProdutoDAO extends GenericDAO<ProductEntity, Long> implements IProductDAO  {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ProductEntity> listByName(String nome) {
		 TypedQuery<ProductEntity> createQuery = 
				 this.entityManager.createQuery("SELECT c FROM ProdutoEntity c WHERE c.nome LIKE CONCAT('%',:nome,'%')", ProductEntity.class);
		 createQuery.setParameter("nome", nome);
		
		List<ProductEntity> pedidoPorNome = createQuery.getResultList();
		
		return pedidoPorNome;
	}

}

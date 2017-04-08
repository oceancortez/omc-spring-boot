/**
 * 
 */
package omc.pedidos.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import omc.pedidos.entity.ProdutoEntity;

/**
 * @author ocean
 *
 */
@Repository
public class ProdutoDAO extends GenericDAO<ProdutoEntity, Long> implements IProdutoDAO  {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ProdutoEntity> listPorNome(String nome) {
		 TypedQuery<ProdutoEntity> createQuery = 
				 this.entityManager.createQuery("SELECT c FROM ProdutoEntity c WHERE c.nome LIKE CONCAT('%',:nome,'%')", ProdutoEntity.class);
		 createQuery.setParameter("nome", nome);
		
		List<ProdutoEntity> pedidoPorNome = createQuery.getResultList();
		
		return pedidoPorNome;
	}

}

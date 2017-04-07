/**
 * 
 */
package omc.pedidos.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import omc.pedidos.entity.PedidoEntity;

/**
 * @author ocean
 *
 */
@Repository
public class PedidoDAO extends GenericDAO<PedidoEntity, Long> implements IPedidoDAO  {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<PedidoEntity> listPorNome(String nome) {
		 TypedQuery<PedidoEntity> createQuery = 
				 this.entityManager.createQuery("SELECT c FROM ClienteEntity c WHERE c.nome LIKE CONCAT('%',:nome,'%')", PedidoEntity.class);
		 createQuery.setParameter("nome", nome);
		
		List<PedidoEntity> pedidoPorNome = createQuery.getResultList();
		
		return pedidoPorNome;
	}

}

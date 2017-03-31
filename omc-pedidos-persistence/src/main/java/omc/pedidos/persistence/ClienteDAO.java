/**
 * 
 */
package omc.pedidos.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import omc.pedidos.entity.ClienteEntity;

/**
 * @author ocean
 *
 */
@Repository
@Transactional
public class ClienteDAO extends GenericDAO<ClienteEntity, Long> implements IClienteDAO  {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ClienteEntity> listPorNome(String nome) {
		 TypedQuery<ClienteEntity> createQuery = 
				 this.entityManager.createQuery("SELECT c FROM ClienteEntity c WHERE c.nome LIKE CONCAT('%',:nome,'%')", ClienteEntity.class);
		 createQuery.setParameter("nome", nome);
		
		List<ClienteEntity> clientesPorNome = createQuery.getResultList();
		
		return clientesPorNome;
	}

}

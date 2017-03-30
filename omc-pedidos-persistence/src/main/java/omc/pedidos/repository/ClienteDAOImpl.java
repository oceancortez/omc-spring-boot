/**
 * 
 */
package omc.pedidos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import omc.pedidos.entity.ClienteEntity;

/**
 * @author ocean
 *
 */
@Repository
@Transactional
public class ClienteDAOImpl implements IClienteDAO{
	
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

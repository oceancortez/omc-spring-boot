/**
 * 
 */
package omc.pedidos.persistence;

import java.util.List;

import omc.pedidos.entity.ClienteEntity;

/**
 * @author ocean
 *
 */
public interface IClienteDAO extends  IGenericDAO<ClienteEntity, Long>  {	
	
	List<ClienteEntity> listPorNome(String nome);

}

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
public interface ClienteDAO {
	
	
	List<ClienteEntity> listPorNome(String nome);

}

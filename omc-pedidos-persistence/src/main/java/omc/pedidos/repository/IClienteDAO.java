/**
 * 
 */
package omc.pedidos.repository;

import java.util.List;

import omc.pedidos.entity.ClienteEntity;

/**
 * @author ocean
 *
 */
public interface IClienteDAO {
	
	
	List<ClienteEntity> listPorNome(String nome);

}

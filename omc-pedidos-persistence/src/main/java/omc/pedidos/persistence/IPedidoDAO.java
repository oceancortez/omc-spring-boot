/**
 * 
 */
package omc.pedidos.persistence;

import java.util.List;

import omc.pedidos.entity.PedidoEntity;

/**
 * @author ocean
 *
 */
public interface IPedidoDAO extends IGenericDAO<PedidoEntity, Long>  {	
	
	List<PedidoEntity> listPorNome(String nome);

}

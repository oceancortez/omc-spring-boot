/**
 * 
 */
package omc.pedidos.business;

import java.util.List;

import omc.pedidos.entity.ClienteEntity;

/**
 * @author 579535
 *
 */
public interface IClienteBusiness {

	List<ClienteEntity> listPorNome(String nome);

	ClienteEntity cadastrarCliente(String cliente);

	List<ClienteEntity> listarClientes();

}

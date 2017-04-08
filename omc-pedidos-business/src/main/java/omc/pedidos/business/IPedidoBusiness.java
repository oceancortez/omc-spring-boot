/**
 * 
 */
package omc.pedidos.business;

import java.util.List;

import omc.pedidos.business.type.PedidoType;

/**
 * @author 579535
 *
 */
public interface IPedidoBusiness {

	List<PedidoType> listPorNome(String nome);

	PedidoType cadastrarPedido(String cliente);

	List<PedidoType> listarPedidos();

}

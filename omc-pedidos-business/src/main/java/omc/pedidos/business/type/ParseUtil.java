/**
 * 
 */
package omc.pedidos.business.type;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import omc.pedidos.entity.PedidoEntity;

/**
 * @author 579535
 *
 */
public class ParseUtil {
	
	/**
	 * Parses the pedido to type.
	 *
	 * @param pedidoEntity the pedido entity
	 * @return the pedido type
	 */
	public static PedidoType parsePedidoToType(PedidoEntity pedidoEntity){
		
		PedidoType pedidoType = new PedidoType();
		
		pedidoType.setCodigo(pedidoEntity.getCodigo());
		pedidoType.setNome(pedidoEntity.getNome());
		pedidoType.setDataCadastro(pedidoEntity.getDataCadastro());
		pedidoType.setDataUltimaAlteracao(pedidoEntity.getDataUltimaAlteracao());
		
		if(pedidoEntity.getClienteEntity() != null){
			final ClienteType clienteType = new ClienteType();
			clienteType.setCodigo(pedidoEntity.getClienteEntity().getCodigo());
			clienteType.setNome(pedidoEntity.getClienteEntity().getNome());
			clienteType.setDataCadastro(pedidoEntity.getClienteEntity().getDataCadastro());
			clienteType.setDataUltimaAlteracao(pedidoEntity.getClienteEntity().getDataUltimaAlteracao());
			pedidoType.setClienteType(clienteType);
		}
		
		if(pedidoEntity.getProdutoEntity() != null){
			final ProdutoType produtoType = new ProdutoType();
			produtoType.setCodigo(pedidoEntity.getProdutoEntity().getCodigo());
			produtoType.setNome(pedidoEntity.getProdutoEntity().getNome());
			produtoType.setQuantidade(pedidoEntity.getProdutoEntity().getQuantidade());
			produtoType.setValor(pedidoEntity.getProdutoEntity().getValor());
			produtoType.setDataCadastro(pedidoEntity.getProdutoEntity().getDataCadastro());
			produtoType.setDataUltimaAlteracao(pedidoEntity.getProdutoEntity().getDataUltimaAlteracao());
			pedidoType.setProdutoType(produtoType);
		}		
		
		return pedidoType;
	}
	
	/**
	 * Parses the lista pedido to type.
	 *
	 * @param pedidoEntities the pedido entities
	 * @return the list
	 */
	public static List<PedidoType> parseListaPedidoToType(List<PedidoEntity> pedidoEntities){
		List<PedidoType> pedidoTypes = null;
		if(CollectionUtils.isNotEmpty(pedidoEntities)){
			pedidoTypes = new ArrayList<>();
			for (int i = 0; i < pedidoEntities.size(); i++) {
				pedidoTypes.add(parsePedidoToType(pedidoEntities.get(i)));
			}			
		}
		return pedidoTypes;
	}

}

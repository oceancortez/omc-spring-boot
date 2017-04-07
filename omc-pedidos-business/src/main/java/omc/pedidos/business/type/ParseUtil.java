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
		
		if(CollectionUtils.isNotEmpty(pedidoEntity.getProdutoEntities())){
			List<ProdutoType> produtoTypes = new ArrayList<>();
			for (int i = 0; i < pedidoEntity.getProdutoEntities().size(); i++) {				
				final ProdutoType produtoType = new ProdutoType();
				produtoType.setCodigo(pedidoEntity.getProdutoEntities().get(i).getCodigo());
				produtoType.setNome(pedidoEntity.getProdutoEntities().get(i).getNome());
				produtoType.setQuantidade(pedidoEntity.getProdutoEntities().get(i).getQuantidade());
				produtoType.setValor(pedidoEntity.getProdutoEntities().get(i).getValor());
				produtoType.setDataCadastro(pedidoEntity.getProdutoEntities().get(i).getDataCadastro());
				produtoType.setDataUltimaAlteracao(pedidoEntity.getProdutoEntities().get(i).getDataUltimaAlteracao());
				
				produtoTypes.add(produtoType);
			}
			pedidoType.setProdutoTypes(produtoTypes);
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

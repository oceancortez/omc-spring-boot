package omc.pedidos.business.type;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import omc.pedidos.entity.PedidoEntity;


/**
 * @author ocean
 * The Class ParseUtil.
 */
public class ParseUtil {
	
	/**
	 * Parses the pedido to type.
	 *
	 * @param pedidoEntity the pedido entity
	 * @return the pedido type
	 */
	public static PedidoType parsePedidoEntityToType(final PedidoEntity pedidoEntity){
		
		final PedidoType pedidoType = new PedidoType();
		
		pedidoType.setCodigo(pedidoEntity.getId().getCodigoPedido());
		pedidoType.setNome(pedidoEntity.getNome());
		pedidoType.setDataCadastro(pedidoEntity.getDataCadastro());
		pedidoType.setDataUltimaAlteracao(pedidoEntity.getDataUltimaAlteracao());
		
		if(pedidoEntity.getClienteEntity() != null){
			pedidoType.setClienteType(parseClienteEntityToType(pedidoEntity));
		}
		
		if(pedidoEntity.getProdutoEntity() != null){
			pedidoType.setProdutoType(parseProdutoEntityToType(pedidoEntity));
		}
		
		return pedidoType;
	}

	/**
	 * Parses the cliente entity to type.
	 *
	 * @param pedidoEntity the pedido entity
	 * @return the cliente type
	 */
	private static ClienteType parseClienteEntityToType(final PedidoEntity pedidoEntity) {
		final ClienteType clienteType = new ClienteType();
		clienteType.setCodigo(pedidoEntity.getClienteEntity().getCodigo());
		clienteType.setNome(pedidoEntity.getClienteEntity().getNome());
		clienteType.setDataCadastro(pedidoEntity.getClienteEntity().getDataCadastro());
		clienteType.setDataUltimaAlteracao(pedidoEntity.getClienteEntity().getDataUltimaAlteracao());
		return clienteType;
	}
	

	/**
	 * Parses the produto entity to type.
	 *
	 * @param pedidoEntity the pedido entity
	 * @return the produto type
	 */
	private static ProdutoType parseProdutoEntityToType(final PedidoEntity pedidoEntity) {
		final ProdutoType produtoType = new ProdutoType();
		produtoType.setCodigo(pedidoEntity.getProdutoEntity().getCodigo());
		produtoType.setNome(pedidoEntity.getProdutoEntity().getNome());
		produtoType.setQuantidade(pedidoEntity.getProdutoEntity().getQuantidade());
		produtoType.setValor(pedidoEntity.getProdutoEntity().getValor());
		produtoType.setDataCadastro(pedidoEntity.getProdutoEntity().getDataCadastro());
		produtoType.setDataUltimaAlteracao(pedidoEntity.getProdutoEntity().getDataUltimaAlteracao());
		return produtoType;
	}
	
	/**
	 * Parses the lista pedido to type.
	 *
	 * @param pedidoEntities the pedido entities
	 * @return the list
	 */
	public static List<PedidoType> parseListaPedidoEntityToType(final List<PedidoEntity> pedidoEntities){
		List<PedidoType> pedidoTypes = null;
		if(CollectionUtils.isNotEmpty(pedidoEntities)){
			pedidoTypes = new ArrayList<>();
			for (int i = 0; i < pedidoEntities.size(); i++) {
				pedidoTypes.add(parsePedidoEntityToType(pedidoEntities.get(i)));
			}			
		}
		return pedidoTypes;
	}

}

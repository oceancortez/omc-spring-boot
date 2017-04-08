package omc.pedidos.business.type;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import omc.pedidos.entity.ClienteEntity;
import omc.pedidos.entity.PedidoEntity;
import omc.pedidos.entity.ProdutoEntity;


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
			pedidoType.setClienteType(parseClienteEntityToType(pedidoEntity.getClienteEntity()));
		}
		
		if(pedidoEntity.getProdutoEntity() != null){
			pedidoType.setProdutoType(parseProdutoEntityToType(pedidoEntity.getProdutoEntity()));
		}
		
		return pedidoType;
	}


	/**
	 * Parses the cliente entity to type.
	 *
	 * @param clienteEntity the cliente entity
	 * @return the cliente type
	 */
	private static ClienteType parseClienteEntityToType(final ClienteEntity clienteEntity) {
		final ClienteType clienteType = new ClienteType();
		clienteType.setCodigo(clienteEntity.getCodigo());
		clienteType.setNome(clienteEntity.getNome());
		clienteType.setDataCadastro(clienteEntity.getDataCadastro());
		clienteType.setDataUltimaAlteracao(clienteEntity.getDataUltimaAlteracao());
		return clienteType;
	}
	

	/**
	 * Parses the produto entity to type.
	 *
	 * @param produtoEntity the produto entity
	 * @return the produto type
	 */
	private static ProdutoType parseProdutoEntityToType(final ProdutoEntity produtoEntity) {
		final ProdutoType produtoType = new ProdutoType();
		produtoType.setCodigo(produtoEntity.getCodigo());
		produtoType.setNome(produtoEntity.getNome());
		produtoType.setQuantidade(produtoEntity.getQuantidade());
		produtoType.setValor(produtoEntity.getValor());
		produtoType.setDataCadastro(produtoEntity.getDataCadastro());
		produtoType.setDataUltimaAlteracao(produtoEntity.getDataUltimaAlteracao());
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

	/**
	 * Parses the lista produto entity to type.
	 *
	 * @param produtoEntities the produto entities
	 * @return the list
	 */
	public static List<ProdutoType> parseListaProdutoEntityToType(List<ProdutoEntity> produtoEntities) {
		List<ProdutoType> produtoTypes = null;
		if(CollectionUtils.isNotEmpty(produtoEntities)){
			produtoTypes = new ArrayList<>();
			for (int i = 0; i < produtoEntities.size(); i++) {
				produtoTypes.add(parseProdutoEntityToType(produtoEntities.get(i)));
			}
		}
		return produtoTypes;
	}

}

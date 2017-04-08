package omc.pedidos.business.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import omc.pedidos.business.type.ClienteType;
import omc.pedidos.business.type.PedidoType;
import omc.pedidos.business.type.ProdutoType;
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
	public static List<ProdutoType> parseListaProdutoEntityToType(final List<ProdutoEntity> produtoEntities) {
		List<ProdutoType> produtoTypes = null;
		if(CollectionUtils.isNotEmpty(produtoEntities)){
			produtoTypes = new ArrayList<>();
			for (int i = 0; i < produtoEntities.size(); i++) {
				produtoTypes.add(parseProdutoEntityToType(produtoEntities.get(i)));
			}
		}
		return produtoTypes;
	}


	/**
	 * Parses the produto type to entity.
	 *
	 * @param produtoType the produto type
	 * @return the produto entity
	 */
	public static ProdutoEntity parseProdutoTypeToEntity(final ProdutoType produtoType) {
		final ProdutoEntity produtoEntity = new ProdutoEntity();
		if(produtoType.getCodigo() != null){
			produtoEntity.setCodigo(produtoType.getCodigo());
		}
		
		produtoEntity.setNome(produtoType.getNome());
		produtoEntity.setValor(produtoType.getValor());
		produtoEntity.setQuantidade(produtoType.getQuantidade());
		
		if(produtoType.getDataCadastro() != null){
			produtoEntity.setDataCadastro(produtoType.getDataCadastro());
		}
		
		if(produtoType.getDataUltimaAlteracao() != null){
			produtoEntity.setDataUltimaAlteracao(produtoType.getDataUltimaAlteracao());
		}		
		return produtoEntity;
	}


	/**
	 * Parses the produto entity type.
	 *
	 * @param produtoEntity the produto entity
	 * @return the produto type
	 */
	public static ProdutoType parseProdutoEntityType(final ProdutoEntity produtoEntity) {
		final ProdutoType produtoType = new ProdutoType();
		produtoType.setCodigo(produtoEntity.getCodigo());				
		produtoType.setNome(produtoEntity.getNome());
		produtoType.setValor(produtoEntity.getValor());
		produtoType.setQuantidade(produtoEntity.getQuantidade());	
		produtoType.setDataCadastro(produtoEntity.getDataCadastro());
		produtoType.setDataUltimaAlteracao(produtoEntity.getDataUltimaAlteracao());

		return produtoType;
	}
	
	/**
	 * Parses the json to type.
	 *
	 * @param object the object
	 * @param json the json
	 * @return the object
	 */
	public static Object parseJsonToType(final String json, final Object object){
		final ObjectMapper mapper  = new ObjectMapper();		
		Object parse = null;

				try {
					parse = mapper.readValue(json, object.getClass());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		return parse;
	}

}

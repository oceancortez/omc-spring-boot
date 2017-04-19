package omc.pedidos.business.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import omc.pedidos.business.type.CategoryType;
import omc.pedidos.business.type.ClienteType;
import omc.pedidos.business.type.PedidoType;
import omc.pedidos.business.type.ProductType;
import omc.pedidos.entity.CategoryEntity;
import omc.pedidos.entity.ClienteEntity;
import omc.pedidos.entity.PedidoEntity;
import omc.pedidos.entity.ProductEntity;


/**
 * @author ocean
 * The Class ParseUtil.
 */
public class ParseUtil {
	
	final static Logger LOG = LoggerFactory.getLogger(ParseUtil.class);
	
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
	private static ProductType parseProdutoEntityToType(final ProductEntity produtoEntity) {
		final ProductType produtoType = new ProductType();
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
	public static List<ProductType> parseListProductEntityToType(final List<ProductEntity> produtoEntities) {
		List<ProductType> produtoTypes = null;
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
	public static ProductEntity parseProdutoTypeToEntity(final ProductType produtoType) {
		final ProductEntity produtoEntity = new ProductEntity();
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
	public static ProductType parseProdutoEntityType(final ProductEntity produtoEntity) {
		final ProductType produtoType = new ProductType();
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
					LOG.error(e.getStackTrace().toString());
				}

		return parse;
	}


	public static String parseTypeToJson(Object object) {
		String parse = "";
		
		final ObjectMapper mapper = new ObjectMapper();
		try {
			parse = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e1) {

			LOG.error(e1.getStackTrace().toString());
		}
		
		return parse;
	}


	public static String parseStringToJson(String parse) {
		
		final ObjectMapper mapper = new ObjectMapper();
		try {
			parse = mapper.writeValueAsString(parse);
		} catch (JsonProcessingException e1) {

			LOG.error(e1.getStackTrace().toString());
		}
		
		return parse;
	}


	public static CategoryEntity parseCategoryTypeToEntity(final CategoryType categoryType) {
		// TODO Auto-generated method stub
		return null;
	}


	public static List<CategoryType> parseListCategoryEntityToType(final List<CategoryEntity> categoryEntities) {
			List<CategoryType> categoryTypes = null;
			
		if(CollectionUtils.isNotEmpty(categoryEntities)){
			categoryTypes = new ArrayList<>();
			for (int i = 0; i < categoryEntities.size(); i++) {
				final CategoryType categoryType = new CategoryType();
				
				categoryType.setId(categoryEntities.get(i).getId());	
				categoryType.setName(categoryEntities.get(i).getName());
				categoryType.setDescription(categoryEntities.get(i).getDescription());
				categoryType.setPicture(categoryEntities.get(i).getPicture());
				categoryType.setDateCreate(categoryEntities.get(i).getDateCreate());
				categoryType.setDateLastModification(categoryEntities.get(i).getDateLastModification());
				
				categoryTypes.add(categoryType);
			}
		}
		return categoryTypes;
	}

}

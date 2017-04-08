package omc.pedidos.business.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.transaction.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import omc.pedidos.business.type.ProdutoType;
import omc.pedidos.business.util.ParseUtil;
import omc.pedidos.entity.ProdutoEntity;
import omc.pedidos.persistence.IProdutoDAO;

/**
 * @author 579535
 *
 */
@Component
public class ProdutoBusiness implements IProdutoBusiness{
	
	@Autowired
	private IProdutoDAO produtoDAO;

	@Override
	public List<ProdutoType> listPorNome(final String nome) {
		return null;
	}

	@Override
	public ProdutoType cadastrarProduto(final String cliente) {
		ProdutoEntity produtoEntity = new ProdutoEntity();
	    ProdutoType produtoType = null;

		produtoType = (ProdutoType) ParseUtil.parseJsonToType(cliente, new ProdutoType());			
		produtoEntity = ParseUtil.parseProdutoTypeToEntity(produtoType);

		try {
			produtoEntity = produtoDAO.persist(produtoEntity);
			produtoEntity = produtoDAO.findById(produtoEntity.getCodigo());
			if(produtoEntity.getCodigo() != null){
				produtoType = new ProdutoType();
				produtoType.setCodigo(produtoEntity.getCodigo());
			}
		} catch (EntityExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransactionRequiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return produtoType;
	}
	
	@Override
	public ProdutoType atualizarProduto(final String cliente) {
		ProdutoEntity produtoEntity = new ProdutoEntity();
	    ProdutoType produtoType = null;
	    
		produtoType = (ProdutoType) ParseUtil.parseJsonToType(cliente, new ProdutoType());		
		produtoEntity = ParseUtil.parseProdutoTypeToEntity(produtoType);

		try {
			produtoEntity = produtoDAO.update(produtoEntity);
			
			produtoType = ParseUtil.parseProdutoEntityType(produtoEntity);
			
		} catch (EntityExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransactionRequiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return produtoType;
	}

	@Override
	public List<ProdutoType> listarProdutos() {
		List<ProdutoEntity> produtoEntities = produtoDAO.findAll();
		List<ProdutoType> produtos = ParseUtil.parseListaProdutoEntityToType(produtoEntities);
		return produtos;
	}

}

package omc.pedidos.business.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.transaction.TransactionRequiredException;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import omc.pedidos.business.type.ProdutoType;
import omc.pedidos.business.util.ParseUtil;
import omc.pedidos.entity.ProdutoEntity;
import omc.pedidos.persistence.IProdutoDAO;

/**
 * @author 579535
 *
 */
@Component
public class ProdutoBusiness implements IProdutoBusiness {

	@Autowired
	private IProdutoDAO produtoDAO;

	@Override
	public List<ProdutoType> listPorNome(final String nome) {
		return null;
	}

	@Override
	public String cadastrarProduto(final String cliente) {
		String retorno = "";
		ProdutoEntity produtoEntity = new ProdutoEntity();
		ProdutoType produtoType = null;

		produtoType = (ProdutoType) ParseUtil.parseJsonToType(cliente, new ProdutoType());
		produtoEntity = ParseUtil.parseProdutoTypeToEntity(produtoType);
		
		
		try {
			produtoEntity = produtoDAO.persist(produtoEntity);
			produtoEntity = produtoDAO.findById(produtoEntity.getCodigo());
			if (produtoEntity.getCodigo() != null) {
				retorno = "Produto ".concat(produtoEntity.getNome().concat(" foi cadastrado com Sucesso!"));
			}
		} catch (EntityExistsException | TransactionRequiredException | IllegalStateException
				| IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			if (e.getCause().getCause() instanceof MySQLIntegrityConstraintViolationException) {
				retorno = "Favor cadastrar outro produto, pois já exite um produto com esse nome!";
			}
		}
		
		return retorno;
	}

	@Override
	public ProdutoType atualizarProduto(final String cliente) {
		ProdutoEntity produtoEntity = new ProdutoEntity();
		ProdutoType produtoType = null;

		produtoType = (ProdutoType) ParseUtil.parseJsonToType(cliente, new ProdutoType());
		produtoEntity = ParseUtil.parseProdutoTypeToEntity(produtoType);

		try {
			produtoType = ParseUtil.parseProdutoEntityType(produtoEntity);
			produtoEntity = produtoDAO.update(produtoEntity);
		} catch (TransactionRequiredException | IllegalStateException | IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
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

	@Override
	public String excluirProduto(String produtosJson) {
		String retorno = "";
		ProdutoType produtoType = (ProdutoType) ParseUtil.parseJsonToType(produtosJson, new ProdutoType());
		ProdutoEntity produtoEntity = ParseUtil.parseProdutoTypeToEntity(produtoType);

		produtoEntity = produtoDAO.findById(produtoEntity.getCodigo());
		if (CollectionUtils.isNotEmpty(produtoEntity.getPedidoEntities())) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < produtoEntity.getPedidoEntities().size(); i++) {
				builder.append("O produto não pode ser excluído, pois ainda está sendo utilizado pelos pedidos abaixo: ");
				builder.append("\n").append(produtoEntity.getPedidoEntities().get(i).getId().getCodigoPedido().toString());
				builder.append("\n").append(produtoEntity.getPedidoEntities().get(i).getNome().toString());
			}
			retorno = builder.toString();
			
			return retorno;	
		}
		
		try {
			produtoDAO.delete(produtoEntity);
			retorno = "{O produto ".concat(produtoType.getNome().concat(" foi excluído com Sucesso!}"));
		} catch (TransactionRequiredException | IllegalStateException | IllegalArgumentException
				| PersistenceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			retorno = "Não foi possível exlcuir o registro ".concat(produtoType.getNome());
			e.printStackTrace();
		}		
		

		return retorno;
	}

}

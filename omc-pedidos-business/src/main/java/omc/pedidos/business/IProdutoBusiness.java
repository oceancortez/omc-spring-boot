/**
 * 
 */
package omc.pedidos.business;

import java.util.List;

import omc.pedidos.business.type.ProdutoType;

/**
 * @author 579535
 *
 */
public interface IProdutoBusiness {

	List<ProdutoType> listPorNome(String nome);

	ProdutoType cadastrarProduto(String produto);

	List<ProdutoType> listarProdutos();

	ProdutoType atualizarProduto(String produtosJson);

}

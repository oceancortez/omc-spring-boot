/**
 * 
 */
package omc.pedidos.persistence;

import java.util.List;

import omc.pedidos.entity.ProdutoEntity;

/**
 * @author ocean
 *
 */
public interface IProdutoDAO extends IGenericDAO<ProdutoEntity, Long>  {	
	
	List<ProdutoEntity> listPorNome(String nome);

}

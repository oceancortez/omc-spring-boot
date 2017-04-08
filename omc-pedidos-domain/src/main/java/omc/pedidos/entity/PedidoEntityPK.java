package omc.pedidos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author ocean
 *
 */

@Embeddable
public class PedidoEntityPK implements Serializable {
	
	private static final long serialVersionUID = 8554875399637332008L;

	@Column(name = "CODPED", nullable = false, updatable = false)
	private Long codigoPedido;
	
    @Column(name = "CODPRD", nullable = false, updatable = false)
	private Long codigoProduto;
    
    public PedidoEntityPK() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codigoPedido
	 * @param codigoProduto
	 */
	public PedidoEntityPK(Long codigoPedido, Long codigoProduto) {
		super();
		this.codigoPedido = codigoPedido;
		this.codigoProduto = codigoProduto;
	}

	/**
	 * @return the codigoPedido
	 */
	public Long getCodigoPedido() {
		return codigoPedido;
	}

	/**
	 * @param codigoPedido the codigoPedido to set
	 */
	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	/**
	 * @return the codigoProduto
	 */
	public Long getCodigoProduto() {
		return codigoProduto;
	}

	/**
	 * @param codigoProduto the codigoProduto to set
	 */
	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoPedido == null) ? 0 : codigoPedido.hashCode());
		result = prime * result + ((codigoProduto == null) ? 0 : codigoProduto.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoEntityPK other = (PedidoEntityPK) obj;
		if (codigoPedido == null) {
			if (other.codigoPedido != null)
				return false;
		} else if (!codigoPedido.equals(other.codigoPedido))
			return false;
		if (codigoProduto == null) {
			if (other.codigoProduto != null)
				return false;
		} else if (!codigoProduto.equals(other.codigoProduto))
			return false;
		return true;
	}	
	
	
	
	

}
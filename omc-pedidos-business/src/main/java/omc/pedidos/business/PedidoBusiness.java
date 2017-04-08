package omc.pedidos.business;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.transaction.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import omc.pedidos.business.type.ParseUtil;
import omc.pedidos.business.type.PedidoType;
import omc.pedidos.entity.PedidoEntity;
import omc.pedidos.persistence.IPedidoDAO;

/**
 * @author 579535
 *
 */
@Component
public class PedidoBusiness implements IPedidoBusiness{
	
	@Autowired
	private IPedidoDAO pedidoDAO;

	@Override
	public List<PedidoType> listPorNome(final String nome) {
		return null;
	}

	@Override
	public PedidoType cadastrarPedido(final String cliente) {
		PedidoEntity pedidoEntity = new PedidoEntity();
		final PedidoType pedidoType = new PedidoType();
		
		final ObjectMapper mapper  = new ObjectMapper();
		
		Object parse = null;

			try {
				parse = mapper.readValue(cliente, PedidoEntity.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
			pedidoEntity = (PedidoEntity) parse;
			PedidoEntity pedidoSalvo = null;
		try {
			pedidoSalvo = pedidoDAO.persist(pedidoEntity);
			pedidoSalvo = pedidoDAO.findById(pedidoEntity.getId().getCodigoPedido());
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

		return pedidoType;
	}

	@Override
	public List<PedidoType> listarPedidos() {
		List<PedidoEntity> pedidoEntities = pedidoDAO.findAll();
		List<PedidoType> pedidoTypes = ParseUtil.parseListaPedidoEntityToType(pedidoEntities);
		return pedidoTypes;
	}

}

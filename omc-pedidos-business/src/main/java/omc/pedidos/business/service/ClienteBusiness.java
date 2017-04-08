/**
 * 
 */
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

import omc.pedidos.entity.ClienteEntity;
import omc.pedidos.persistence.IClienteDAO;

/**
 * @author 579535
 *
 */
@Component
public class ClienteBusiness implements IClienteBusiness{
	
	@Autowired
	private IClienteDAO clienteDAO;

	@Override
	public List<ClienteEntity> listPorNome(String nome) {
		return clienteDAO.listPorNome(nome);
	}

	@Override
	public ClienteEntity cadastrarCliente(String cliente) {
		ClienteEntity clienteEntity = new ClienteEntity();
		
		ObjectMapper mapper  = new ObjectMapper();
		
		Object parse = null;

			try {
				parse = mapper.readValue(cliente, ClienteEntity.class);
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
	
		
		clienteEntity = (ClienteEntity) parse;
		ClienteEntity clienteSalvo = null;
		try {
			clienteSalvo = clienteDAO.persist(clienteEntity);
			clienteSalvo = clienteDAO.findById(clienteSalvo.getCodigo());
		} catch (EntityExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransactionRequiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clienteSalvo;
	}

	@Override
	public List<ClienteEntity> listarClientes() {
		return clienteDAO.findAll();
	}

}

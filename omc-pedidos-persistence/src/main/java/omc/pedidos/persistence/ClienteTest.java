package omc.pedidos.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

import omc.pedidos.entity.ClienteEntity;

@ComponentScan
public class ClienteTest implements CommandLineRunner{
	
	private IClienteDAO clienteDAO;
	
	public ClienteTest(IClienteDAO dao) {
		this.clienteDAO = dao;
	}

	@Override
	public void run(String... arg0) throws Exception {
		ClienteEntity oxi = new ClienteEntity("oxi", new Date(), new Date());
		ClienteEntity oc = new ClienteEntity("oc", new Date(), new Date());
		ClienteEntity omc = new ClienteEntity("omc", new Date(), new Date());
		
		List<ClienteEntity> clientes = new ArrayList<ClienteEntity>();
		clientes.add(oxi);
		clientes.add(oc);
		clientes.add(omc);
		
		//this.clienteDAO.save(clientes);
	}

}

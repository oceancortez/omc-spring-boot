package omc.pedidos.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import omc.pedidos.rest.CategoryRestful;
import omc.pedidos.rest.ClienteRestful;
import omc.pedidos.rest.PedidoRestful;
import omc.pedidos.rest.ProductRestful;

@Component
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(ClienteRestful.class);
		register(PedidoRestful.class);
		register(ProductRestful.class);
		register(CategoryRestful.class);
	}
}

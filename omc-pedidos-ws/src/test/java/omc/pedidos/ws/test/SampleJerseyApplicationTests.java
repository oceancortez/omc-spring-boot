/**
 * 
 */
package omc.pedidos.ws.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import omc.pedidos.service.SampleApplication;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * @author ocean
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleApplication.class , webEnvironment = WebEnvironment.RANDOM_PORT)
public class SampleJerseyApplicationTests {
	
	@Autowired 
	private TestRestTemplate restTemplate;
	
	
	@Test
	public void rootReturnsHelloWorld() {
		assertThat(this.restTemplate.getForObject("/rest/cliente/listar-por?nome=oxi", String.class)).contains("Oxi");
	}
	
	
	@Test
	public void contextLoads() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("/rest/cliente/test",
				String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}

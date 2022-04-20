package br.com.feltex.utilizando.gradle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UtilizandoGradleApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testarAPI() {

	var resultado =	 restTemplate.getForEntity("http://localhost:" + port+ "/status", String.class);
		Assertions.assertEquals(HttpStatus.OK, resultado.getStatusCode());
		Assertions.assertEquals("Ola, seja bem vindo!", resultado.getBody());
	}

}

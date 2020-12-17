package com.dar.everisdarmytasksms.controllers;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class TaskControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() throws JSONException {
		String response = this.restTemplate.getForObject("/tasks", String.class);
		JSONAssert.assertEquals("[{\"id\":1,\"taskstatus\":\"In progress\",\"description\":\"Backend, microservicios con Spring boot.\"},"
				+ "{\"id\":2,\"taskstatus\":\"Pending\",\"description\":\"Repositorio Proyecto, crear repositorio público de GitHub.\"},"
				+ "{\"id\":3,\"taskstatus\":\"Finished\",\"description\":\"DevOps, desplegar imagen de la aplicación desde DockerHub en AKS.\"}]", response, true);
		JSONAssert.assertEquals("[{id:1},{id:2},{id:3}]", response, false);

	}
	
	@Test
	public void contextLoads_count() throws JSONException {
		String response = this.restTemplate.getForObject("/count", String.class);
		JSONAssert.assertEquals("3", response, true);
	}

}

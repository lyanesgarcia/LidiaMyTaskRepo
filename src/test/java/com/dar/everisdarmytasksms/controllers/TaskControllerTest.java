/*
package com.dar.everisdarmytasksms.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;

import com.dar.everisdarmytasksms.data.TaskRepository;
import com.dar.everisdarmytasksms.model.Task;
import com.dar.everisdarmytasksms.service.TaskService;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskRestController.class)
public class TaskControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TaskService taskservice;
	
	@Test
	public void retrieveAllItems_basic() throws Exception {
		when(taskservice.retrieveAllItems()).thenReturn(Arrays.asList(
				new Task(1,"In progress", "Backend, microservicios con Spring boot."), 
				new Task(2, "Pending", "Repositorio Proyecto, crear repositorio público de GitHub."),
				new Task(3, "Finished", "DevOps, desplegar imagen de la aplicación desde DockerHub en AKS.")));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/tasks")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":1,\"taskstatus\":\"In progress\",\"description\":\"Backend, microservicios con Spring boot.\"},"
						+ "{\"id\":2,\"taskstatus\":\"Pending\",\"description\":\"Repositorio Proyecto, crear repositorio público de GitHub.\"},"
						+ "{\"id\":3,\"taskstatus\":\"Finished\",\"description\":\"DevOps, desplegar imagen de la aplicación desde DockerHub en AKS.\"}]"))
				.andReturn(); 
	
	}
	
	@Test
	public void retrieveAllItems_noitems() throws Exception {
		when(taskservice.retrieveAllItems()).thenReturn(Arrays.asList());
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/tasks")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[]"))
				.andReturn();
	
	}
	
	@Test
	public void count() throws Exception {
		when(taskservice.count()).thenReturn((long) 3);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/count")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("3"))
				.andReturn();
	
	}
	
	@Test
	public void findTaskById() throws Exception {
		Task o = new Task(2, "Pending", "Repositorio Proyecto, crear repositorio público de GitHub.");
		Optional<Task> task = Optional.of(o);
		when(taskservice.findById((long)2)).thenReturn(task);
		RequestBuilder request = MockMvcRequestBuilders.get("/find/2").accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":2,\"taskstatus\":\"Pending\",\"description\":\"Repositorio Proyecto, crear repositorio público de GitHub.\"}"))
				.andReturn();
	}
	
	@Test
	public void findTaskWithState() throws Exception {
		when(taskservice.findAllWithState("Pending")).thenReturn(Arrays.asList(new Task(2, "Pending", "Repositorio Proyecto, crear repositorio público de GitHub.")));
		RequestBuilder request = 
				MockMvcRequestBuilders.get("/tasks/status/Pending")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().json("[{\"id\":2,\"taskstatus\":\"Pending\",\"description\":\"Repositorio Proyecto, crear repositorio público de GitHub.\"}]"))
			.andReturn();
	}
	
	
	@Test
	public void delete() throws Exception {
		when(taskservice.deleteById(4)).thenReturn(Arrays.asList(new Task(2, "Pending", "Back")));
		RequestBuilder request = 
				MockMvcRequestBuilders.delete("/tasks/{id}", 4)
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":2,\"taskstatus\":\"Pending\",\"description\":\"Back\"}]"))
				.andReturn();	
	}
	
	@Test
	public void update() throws Exception {
		when(taskservice.update(4, "Pending", "Prueba")).thenReturn(new Task(4, "Pending", "Prueba"));
		
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<String, String>();
		requestParams.add("id", "4");
		requestParams.add("task_status", "Pending");
		requestParams.add("description","Prueba");
		
		RequestBuilder request = MockMvcRequestBuilders
				.put("/tasks")
				.params(requestParams)
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{'id':4,'taskstatus':'Pending','description':'Prueba'}"))
				.andReturn();
	}
	
	@Test
	public void insert() throws Exception {
		when(taskservice.saveByEntity(Mockito.any(Task.class))).thenReturn(new Task(4, "Pending", "Prueba"));
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<String, String>();
		requestParams.add("id", "4");
		requestParams.add("taskstatus", "Pending");
		requestParams.add("description","Prueba");
		
		RequestBuilder request = MockMvcRequestBuilders
				.post("/tasks")
				.params(requestParams)
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{'id':4,'taskstatus':'Pending','description':'Prueba'}"))
				.andReturn();
	}
	
	

}
*/
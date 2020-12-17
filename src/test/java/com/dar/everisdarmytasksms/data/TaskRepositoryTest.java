package com.dar.everisdarmytasksms.data;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dar.everisdarmytasksms.model.Task;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTest {
	
	@Autowired
	private TaskRepository repository;
	
	@Test
	public void testFindAll() {
		List<Task> tasks = repository.findAll();
		assertEquals(3, tasks.size());
	}
	
	@Test
	public void testFindOne() {
		Task tasks = repository.findById(1).get();
		assertEquals("In progress", tasks.getTask_status());
		assertEquals("Backend, microservicios con Spring boot.", tasks.getDescription());
	}

}
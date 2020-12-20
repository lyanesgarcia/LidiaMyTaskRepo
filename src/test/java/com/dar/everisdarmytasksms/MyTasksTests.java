package com.dar.everisdarmytasksms;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dar.everisdarmytasksms.controllers.TaskRestController;

@SpringBootTest
class MyTasksTests {

	@Autowired
	private TaskRestController restcontroller;
	
	@Test
	void contextLoads() {
		assertThat(restcontroller).isNotNull();
	}

}

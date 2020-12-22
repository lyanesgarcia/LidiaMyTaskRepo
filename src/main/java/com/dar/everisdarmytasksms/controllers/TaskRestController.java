package com.dar.everisdarmytasksms.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dar.everisdarmytasksms.model.Task;
import com.dar.everisdarmytasksms.service.TaskService;

@CrossOrigin(origins= "*")
@RestController
public class TaskRestController {
	@Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> retrieveAllItems() {
        return taskService.retrieveAllItems();
    }

    @GetMapping("/count")
    public Long count() {
        return taskService.count();
    }
    
    @GetMapping("/find/{id}")
	public Optional<Task> findById(@PathVariable("id") Long id) {
	    return taskService.findById(id);
	}    
    
    @RequestMapping(value="tasks/status/{status}", method=RequestMethod.GET, produces = "application/json")
    public List<Task> findAllWithState(@PathVariable String status) {
    	return taskService.findAllWithState(status);
    }

    @DeleteMapping("/tasks/{id}")
    public List<Task> deleteById(@PathVariable int id) {
        return taskService.deleteById(id);  
    }
    
    @PostMapping(path="tasks", produces = "application/json")
    public Task saveByEntity(@RequestBody Task task) {
    	return taskService.saveByEntity(task);
    }
    
    @RequestMapping(value="tasks", method=RequestMethod.PUT, produces = "application/json")
    public Task update(@RequestBody Task task) {
    	return taskService.update(task.getId(), task.getTask_status(), task.getDescription());
    }
    

}

package com.dar.everisdarmytasksms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dar.everisdarmytasksms.data.TaskRepository;
import com.dar.everisdarmytasksms.model.Task;

@Component
public class TaskService {
	@Autowired
	private TaskRepository repository;
	
	public List<Task> retrieveAllItems(){
		List<Task> items = repository.findAll();
		return items;
	}
	
	public Long count() {
		return repository.count();
	}
	
	public List<Task> deleteById(Integer taskId) {
		repository.deleteById(taskId); 
		return repository.findAll();
    }
	
	public Task saveByEntity(Task task) {
		return task != null ? repository.save(task): new Task(); 
    }
	
	public Task update(int id, String task_status, String description) {
		Task t = repository.findById(id).get();
		t.setId(id);
		t.setTask_status(task_status);
		t.setDescription(description);
		return repository.save(t); 
    }
	
	public Optional<Task> findById(long id) {
		return repository.findById((int) id);
	}

	
	public List<Task> findAllWithState(String state){
		List<Task> full_list = this.retrieveAllItems();
		List<Task> partial_list = new ArrayList<Task>();
		for(Task task: full_list) {
			if(task.getTask_status().contentEquals(state)) {
				partial_list.add(task);
			}
		}
		return partial_list;
	}

}
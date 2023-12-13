package it.pietro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pietro.models.Dipendente;
import it.pietro.models.Stato;
import it.pietro.models.Task;
import it.pietro.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	public List<Task> findAllTasks(){
		return taskRepository.findAll();
	}
	
	public Optional<Task> findTaskById(int id) {
		return taskRepository.findById(id);
	}
	
	public void deleteTaskById(int id) {
		taskRepository.deleteById(id);
	}
	
	public void insertTaskObj(Task task) {
		taskRepository.save(task);
	}
	
	public void insertTaskParams(String titolo, String descrizione, String dataFine, Dipendente dipendente) {
		taskRepository.save(new Task(titolo, descrizione, dataFine, dipendente));
	}
	
	public void updateTaskByIdParam(String titolo, String descrizione, Stato stato, String dataInizio, String dataFine, Dipendente dipendente, int id_task) {
		taskRepository.updateTaskById(titolo, descrizione, stato, dataInizio, dataFine, dipendente, id_task);
	}
	
	public void updateTaskById(Task task) {
		taskRepository.updateTaskById(task.getTitolo(), task.getDescrizione(), task.getStato(), task.getDataInizio(), task.getDataFine(), task.getDipendente(), task.getId_task());
	}
}

package it.pietro.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.pietro.models.Dipendente;
import it.pietro.models.Stato;
import it.pietro.models.Task;
import it.pietro.services.DipendenteService;
import it.pietro.services.TaskService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/task")
public class TaskController {

	@Autowired
	TaskService taskService;
	@Autowired
	DipendenteService dipendenteService;
	
	@PostMapping("/insertobj")
	public void insertTask(@RequestBody Task task) {
		taskService.insertTaskObj(task);
	}
	
	@PostMapping("/insertparams")
	public void insertTask(@RequestParam String titolo, String descrizione, String dataFine, int id_dipendente) {
		Optional<Dipendente> dipendente = dipendenteService.findDipendenteById(id_dipendente);
		taskService.insertTaskParams(titolo, descrizione, dataFine, dipendente.get());
	}
	
	@PutMapping("updateobj")
	public void updateTask(@RequestBody Task task) {
		taskService.updateTaskById(task);
	}
	
	@PutMapping("/updateparams")
	public void updateTask(@RequestParam String titolo, String descrizione, int stato, String dataInizio, String dataFine, int id_dipendente, int id_task) {
		Stato enumStato = Stato.CREATO;
		switch(stato) {
			case 0: enumStato = Stato.CREATO; break;
			case 1: enumStato = Stato.IN_PROGRESS; break;
			case 2: enumStato = Stato.FINITO; break;
		}
		Optional<Dipendente> dipendente = dipendenteService.findDipendenteById(id_dipendente);
		taskService.updateTaskByIdParam(titolo, descrizione, enumStato, dataInizio, dataFine, dipendente.get(), id_task);
	}
	
	@DeleteMapping("/delete")
	public void deleteTask(@RequestParam int id) {
		taskService.deleteTaskById(id);
	}
	
	@GetMapping("/selecttasks")
	public List<Task> selectTasks(){
		return taskService.findAllTasks();
	}
}

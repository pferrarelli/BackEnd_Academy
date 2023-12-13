package it.pietro.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import it.pietro.models.Dipendente;
import it.pietro.models.Task;
import it.pietro.services.DipendenteService;
import it.pietro.services.TaskService;

@Component
@Order(2)
public class CLRDTask implements CommandLineRunner {

	@Autowired
	DipendenteService dipendenteService;
	
	@Autowired
	TaskService taskService;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("\n\nCLRTask: inserisco 3 tasks al db");
		
		Dipendente dipendente1 = dipendenteService.findDipendenteById(1).get();
		Dipendente dipendente2 = dipendenteService.findDipendenteById(2).get();
		Dipendente dipendente3 = dipendenteService.findDipendenteById(3).get();
		
		taskService.insertTaskObj(new Task("Titolo1", "Descrizione1", "12/12/23", dipendente1));
		taskService.insertTaskObj(new Task("Titolo2", "Descrizione2", "11/12/23", dipendente2));
		taskService.insertTaskObj(new Task("Titolo3", "Descrizione3", "10/12/23", dipendente3));
	}
}

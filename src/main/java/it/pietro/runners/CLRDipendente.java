package it.pietro.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import it.pietro.models.Dipendente;
import it.pietro.services.DipendenteService;

@Component
@Order(1)
public class CLRDipendente implements CommandLineRunner{

	@Autowired
	DipendenteService dipendenteService;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("\n\nCLRDipendente: inserisco 9 dipendenti al db");
		
		dipendenteService.insertDipendenteObj(new Dipendente("A", "AA"));
		dipendenteService.insertDipendenteObj(new Dipendente("B", "BB"));
		dipendenteService.insertDipendenteObj(new Dipendente("C", "CC"));
		dipendenteService.insertDipendenteObj(new Dipendente("D", "DD"));
		dipendenteService.insertDipendenteObj(new Dipendente("E", "EE"));
		dipendenteService.insertDipendenteObj(new Dipendente("F", "FF"));
		dipendenteService.insertDipendenteObj(new Dipendente("G", "GG"));
		dipendenteService.insertDipendenteObj(new Dipendente("H", "HH"));
		dipendenteService.insertDipendenteObj(new Dipendente("I", "II"));	
	}
	
}

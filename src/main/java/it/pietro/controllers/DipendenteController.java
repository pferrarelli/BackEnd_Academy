package it.pietro.controllers;

import java.util.List;

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
import it.pietro.services.DipendenteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/dipendente")
public class DipendenteController {

	@Autowired
	DipendenteService dipendenteService;
	
	@PostMapping("/insertobj")
	public void insertDipendente(@RequestBody Dipendente dipendente) {
		dipendenteService.insertDipendenteObj(dipendente);
	}
	
	@PostMapping("/insertparams")
	public void insertDipendente(@RequestParam String nome, String cognome) {
		dipendenteService.insertDipendenteParams(nome, cognome);
	}
	
	@PutMapping("updateobj")
	public void updateDipendente(@RequestBody Dipendente dipendente) {
		dipendenteService.updateDipendenteById(dipendente);
	}
	
	@PutMapping("/updateparams")
	public void updateDipendente(@RequestParam String nome, String cognome, int id_dipendente) {
		dipendenteService.updateDipendenteByIdParam(nome, cognome, id_dipendente);
	}
	
	@DeleteMapping("/delete")
	public void deleteDipendente(@RequestParam int id) {
		dipendenteService.deleteDipendenteById(id);
	}
	
	@GetMapping("/selectdipendenti")
	public List<Dipendente> selectDipendenti(){
		return dipendenteService.findAllDipendenti();
	}
}

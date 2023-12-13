package it.pietro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pietro.models.Dipendente;
import it.pietro.repositories.DipendenteRepository;

@Service
public class DipendenteService {

	@Autowired
	DipendenteRepository dipendenteRepository;
	
	public List<Dipendente> findAllDipendenti(){
		return dipendenteRepository.findAll();
	}
	
	public Optional<Dipendente> findDipendenteById(int id) {
		return dipendenteRepository.findById(id);
	}
	
	public void deleteDipendenteById(int id) {
		dipendenteRepository.deleteById(id);
	}
	
	public void insertDipendenteObj(Dipendente dipendente) {
		dipendenteRepository.save(dipendente);
	}
	
	public void insertDipendenteParams(String nome, String cognome) {
		dipendenteRepository.save(new Dipendente(nome, cognome));
	}
	
	public void updateDipendenteByIdParam(String nome, String cognome, int id_dipendente) {
		dipendenteRepository.updateDipendenteById(nome, cognome, id_dipendente);
	}
	
	public void updateDipendenteById(Dipendente dipendente) {
		dipendenteRepository.updateDipendenteById(dipendente.getNome(), dipendente.getCognome(), dipendente.getId_dipendente());
	}
}

package it.pietro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import it.pietro.models.Dipendente;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer>{

	/* Metodi predefiniti: non occorre dichiararli nel Repository. 
	 I principali:
	 
	 Optional<T> save(T t);
	 saveAll(Iterable<S> entities)
	 
	 List<T> findAll();
	 
	 Optional<T> findById(id);
	 Iterable<T> findAllById(Iterable<ID> ids)
	 
	 boolean existsById(id); 
	 
	 delete(T); 
	 deleteById(id);
	 deleteAll()

	 count();
	 ...
	 */
	
	/* JPQL */ 
	@Transactional
	@Modifying
	@Query("UPDATE Dipendente d SET d.nome = ?1, d.cognome = ?2 where d.id_dipendente = ?3")
	void updateDipendenteById(String nome, String cognome, int id_dipendente);
	
}

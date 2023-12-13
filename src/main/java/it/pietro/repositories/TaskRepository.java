package it.pietro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import it.pietro.models.Dipendente;
import it.pietro.models.Stato;
import it.pietro.models.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

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
	
	@Transactional
	@Modifying
	@Query("UPDATE Task t SET t.titolo = ?1, t.descrizione = ?2, t.stato = ?3, t.dataInizio = ?4, t.dataFine = ?5, t.dipendente= ?6 where t.id_task = ?7")
	void updateTaskById(String titolo, String descrizione, Stato stato, String dataInizio, String dataFine, Dipendente dipendente, int id_task);
}

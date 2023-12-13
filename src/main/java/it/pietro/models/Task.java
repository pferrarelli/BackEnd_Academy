package it.pietro.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_task;
	
	@Column(nullable = false)
	private String titolo;
	
	@Column(nullable = false)
	private String descrizione;
	
	@Column(nullable = false)
	private Stato stato;
	
	// può essere null perché dataInizio non viene inserita finché lo stato non cambia in IN_PROGRESS
	private String dataInizio;
	
	@Column(nullable = false)
	private String dataFine;
	
	@ManyToOne
	@JoinColumn
	private Dipendente dipendente;
	
	public Task() {}
	
	/**
	 * dataInizio non viene inserita finché lo stato non cambia in IN_PROGRESS
	 */
	public Task(String titolo, String descrizione, String dataFine, Dipendente dipendente) {
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.stato = Stato.CREATO;
		this.dataFine = dataFine;
		this.dipendente = dipendente;
	}

	public int getId_task() {
		return id_task;
	}

	public void setId_task(int id_task) {
		this.id_task = id_task;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataFine, dataInizio, descrizione, dipendente, id_task, stato, titolo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(dataFine, other.dataFine) && Objects.equals(dataInizio, other.dataInizio)
				&& Objects.equals(descrizione, other.descrizione) && Objects.equals(dipendente, other.dipendente)
				&& id_task == other.id_task && stato == other.stato && Objects.equals(titolo, other.titolo);
	}

	@Override
	public String toString() {
		return "Task [id_task=" + id_task + ", titolo=" + titolo + ", descrizione=" + descrizione + ", stato=" + stato
				+ ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", dipendente=" + dipendente + "]";
	}
	
}

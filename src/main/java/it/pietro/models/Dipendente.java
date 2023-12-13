package it.pietro.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Dipendente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_dipendente;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@OneToMany(mappedBy = "dipendente")
	@JsonIgnore
	private List<Task> tasks = new ArrayList<>();
	 
	public Dipendente() {}
	
	public Dipendente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public int getId_dipendente() {
		return id_dipendente;
	}

	public void setId_dipendente(int id_dipendente) {
		this.id_dipendente = id_dipendente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, id_dipendente, nome, tasks);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dipendente other = (Dipendente) obj;
		return Objects.equals(cognome, other.cognome) && id_dipendente == other.id_dipendente
				&& Objects.equals(nome, other.nome) && Objects.equals(tasks, other.tasks);
	}

	@Override
	public String toString() {
		return "Dipendente [id_dipendente=" + id_dipendente + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	
}

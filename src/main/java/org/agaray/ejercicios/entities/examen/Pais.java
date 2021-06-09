package org.agaray.ejercicios.entities.examen;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pais {

	
	//==============================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	@OneToMany(mappedBy = "pais")
	private List<Persona> personas;


	
	
	// =======================
	
	public Pais() {
		this.personas = new ArrayList<>();
	}

	public Pais(String nombre) {
		super();
		this.nombre = nombre;
		this.personas = new ArrayList<>();
	}
	// =======================

	public Integer getNumHabitantes() {
		return this.personas.size();
	}
	
	public Long getId() {
		return id;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// =======================

}

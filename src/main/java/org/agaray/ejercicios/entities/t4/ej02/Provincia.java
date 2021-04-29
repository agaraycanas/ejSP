package org.agaray.ejercicios.entities.t4.ej02;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Provincia {
	
	// =======================================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String nombre;

	@ManyToOne(cascade = {CascadeType.ALL})
	private CCAA ccaa;

	// =======================================
	
	public Provincia() {
		super();
		this.nombre = "Desconocida";
	}
	
	public Provincia(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	// *************************************

	public Long getId() {
		return id;
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

	public CCAA getCcaa() {
		return ccaa;
	}

	public void setCcaa(CCAA ccaa) {
		this.ccaa = ccaa;
	}
	
	
}

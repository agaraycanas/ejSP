package org.agaray.ejercicios.entities.examen;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Persona {

	//==============================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nombre;
	private String sexo;
	private Integer anyo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Pais pais;
	
	
	
	
	//==============================

	public Persona() {
	}

	public Persona(String nombre, String sexo, Integer anyo, Pais pais) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
		this.anyo = anyo;
		if (pais != null) {
			this.pais = pais;
		}
	}

	//==============================

	
	public String getMadurez() {
		String sol = "maduro";
		if (this.anyo>=1995) {
			sol="joven";
		}
		if (this.anyo<1960) {
			sol="anciano";
		}
		return sol;
		
	}
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getAnyo() {
		return anyo;
	}

	public void setAnyo(Integer anyo) {
		this.anyo = anyo;
	}
	

	
}

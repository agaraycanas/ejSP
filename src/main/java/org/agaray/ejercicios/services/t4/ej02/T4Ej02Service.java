package org.agaray.ejercicios.services.t4.ej02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.agaray.ejercicios.entities.t4.ej02.CCAA;
import org.agaray.ejercicios.entities.t4.ej02.Provincia;
import org.agaray.ejercicios.repositories.t4.ej02.CCAARepository;
import org.agaray.ejercicios.repositories.t4.ej02.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class T4Ej02Service {
	@Autowired
	private CCAARepository ccaaRepository;

	@Autowired
	private ProvinciaRepository provinciaRepository;

	private Map<String, List<String>> bd;
	
	public T4Ej02Service() {
		this.bd = new HashMap<String,List<String>>();
		
		this.bd.put("Andalucía", Arrays.asList("Almería","Cádiz","Córdoba","Granada","Huelva","Jaén","Málaga","Sevilla"));
		this.bd.put("Aragón", Arrays.asList("Huesca","Teruel","Zaragoza"));
		this.bd.put("Asturias (Principado de)", Arrays.asList("Asturias"));
		this.bd.put("Canarias",Arrays.asList("Palmas (Las)","Santa Cruz de Tenerife"));
		this.bd.put("Cantabria",Arrays.asList("Cantabria"));
		this.bd.put("Castilla y León",Arrays.asList("Ávila","Burgos","León","Palencia","Salamanca","Segovia","Soria","Valladolid","Zamora"));
		this.bd.put("Castilla-La Mancha",Arrays.asList("Albacete","Ciudad Real","Cuenca","Guadalajara","Toledo"));
		this.bd.put("Cataluña",Arrays.asList("Barcelona","Gerona","Lérida","Tarragona"));
		this.bd.put("Ceuta (Ciudad de)",Arrays.asList("Ceuta"));
		this.bd.put("Comunidad Valenciana",Arrays.asList("Alicante","Castellón","Valencia"));
		this.bd.put("Extremadura",Arrays.asList("Badajoz",
                "Cáceres"));
		this.bd.put("Galicia",Arrays.asList("Coruña (La)","Lugo","Orense","Pontevedra"));
		this.bd.put("Islas Baleares",Arrays.asList("Islas Baleares"));
		this.bd.put("Madrid (Comunidad de)",Arrays.asList("Madrid"));
		this.bd.put("Melilla (Ciudad de)",Arrays.asList("Melilla"));
		this.bd.put("Murcia (Región de)",Arrays.asList("Murcia"));
		this.bd.put("Navarra (Comunidad Foral de)",Arrays.asList("Navarra"));
		this.bd.put("País Vasco",Arrays.asList("Álava","Guipúzcoa","Vizcaya"));
		this.bd.put("Rioja (La)",Arrays.asList("Rioja (La)"));
	}

	public void init() {
		provinciaRepository.deleteAll();
		ccaaRepository.deleteAll();
		for (String nombreCCAA: this.bd.keySet()) {
			CCAA nuevaCCAA = new CCAA(nombreCCAA);
			ccaaRepository.save(nuevaCCAA);
			
			for (String nombreProvincia : bd.get(nombreCCAA)) {
				Provincia nuevaProvincia = new Provincia(nombreProvincia);
				nuevaProvincia.setCcaa(nuevaCCAA);
				nuevaCCAA.getProvincias().add(nuevaProvincia);
				provinciaRepository.save(nuevaProvincia);
			}
		}

	}

	public List<CCAA> getCCAAs() {
		return ccaaRepository.findAll();
	}
	
	public List<Provincia> getProvincias(String ccaaNombre) {
		CCAA ccaa = ccaaRepository.getByNombre(ccaaNombre);
		return (List<Provincia>) ccaa.getProvincias(); 
	}
}

package org.agaray.ejercicios.controllers.examen;

import org.agaray.ejercicios.entities.examen.Persona;
import org.agaray.ejercicios.exception.DangerException;
import org.agaray.ejercicios.exception.InfoException;
import org.agaray.ejercicios.helpers.PRG;
import org.agaray.ejercicios.repositories.examen.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository;

	@GetMapping("c")
	public String cPersonaGET(ModelMap m) {
		m.put("view", "examen/personaCGET");
		return "_t/frame";
	}

	@PostMapping("c")
	public void cPersonaPOST(@RequestParam("nombre") String nombre, @RequestParam("sexo") String sexo,
			@RequestParam("anyo") Integer anyo) throws DangerException, InfoException {
		try {
			personaRepository.save(new Persona(nombre, sexo, anyo));
		}
		catch (Exception e) {
			PRG.error("Nombre de persona "+ nombre +" ya existente","/persona/c");
		}
		PRG.info("Usuario "+nombre+" registrado", "/persona/c");
	}

	@GetMapping("r")
	public String rPersonaGET(ModelMap m) {
		m.put("personas", personaRepository.findAll());
		m.put("view", "examen/personaR");
		return "_t/frame";
	}

	@GetMapping("rf")
	public String rPersonaFiltroGET(@RequestParam(value = "sexo", required = false) String sexo, ModelMap m) {
		if (sexo == null) {
			sexo = "hombre";
		}
		m.put("personas", personaRepository.findAllBySexo(sexo));
		m.put("sexo", sexo);
		m.put("view", "examen/personaRF");
		return "_t/frame";
	}

}

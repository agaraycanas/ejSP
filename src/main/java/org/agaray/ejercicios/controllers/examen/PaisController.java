package org.agaray.ejercicios.controllers.examen;

import org.agaray.ejercicios.entities.examen.Pais;
import org.agaray.ejercicios.exception.DangerException;
import org.agaray.ejercicios.helpers.PRG;
import org.agaray.ejercicios.repositories.examen.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("pais")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping("c")
	public String paisCGET(
			ModelMap m
			) {
		m.put("view", "examen/paisCGet");
		return "_t/frame";
	}
	
	@PostMapping("c")
	public String paisCPost(
			@RequestParam("nombre") String nombre
			) throws DangerException {
		try {
			paisRepository.save(new Pais(nombre));
		}
		catch (Exception e) {
			PRG.error("Error al crear el país","/pais/c");
		}
		return "redirect:/pais/r";
	}
	
	@GetMapping("r")
	public String paisRGet(
			ModelMap m
			) {
		m.put("paises",paisRepository.findAll());
		m.put("view", "examen/paisR");
		return "_t/frame";
	}
	
}

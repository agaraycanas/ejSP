package org.agaray.ejercicios.controllers;

//import static java.util.Map.entry; 
import java.util.Map;
import org.agaray.ejercicios.helpers.H;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/t2")
public class Tema2Controller {

	@GetMapping("ej10")
	public String ej10(H h, ModelMap m) {
		m.put("view", "t2/ej10/uno");
		return "_t/frame";
	}

	@GetMapping("ej11")
	public String ej11(H h, ModelMap m) {
		m.put("arrayValueLabel",
				Map.ofEntries(Map.entry("D", "Deporte"), Map.entry("C", "Cine"), Map.entry("TV", "Televisión")));
		m.put("view", "t2/ej11/uno");
		return "_t/frame";
	}

	@GetMapping(value = { "ej18/1", "ej18" })
	public String ej18_1(ModelMap m) {
		m.put("view", "t2/ej18/uno");
		return "_t/frame";
	}

	@GetMapping("ej18/2")
	public String ej18_2(
			ModelMap m,
			@RequestParam("nOP") Integer nOP
			) {
		String[] etiqueta = {"uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez","once","doce","trece","catorce","quince"};
		m.put("nOP", nOP);
		m.put("etiqueta", etiqueta);
		m.put("view","t2/ej18/dos");
		return "_t/frame";	
	}

	@GetMapping("ej18/3")
	public String ej18_3(
			ModelMap m,
			@RequestParam("n") Integer n
			) {
		m.put("n", n);
		m.put("suma", n+2);
		m.put("view", "t2/ej18/tres");
		return "_t/frame";
	}

}

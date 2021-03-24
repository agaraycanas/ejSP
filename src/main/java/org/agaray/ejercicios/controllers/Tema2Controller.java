package org.agaray.ejercicios.controllers;


//import static java.util.Map.entry; 
import java.util.Map;
import org.agaray.ejercicios.helpers.H;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/t2")
public class Tema2Controller {
	
	@GetMapping("ej10")
	public String ej10(H h,ModelMap m) {
		m.put("view","t2/ej10/uno");
		return "_t/frame";
	}
	
	@GetMapping("ej11")
	public String ej11(H h, ModelMap m) {
		m.put("arrayValueLabel",Map.ofEntries( Map.entry("D", "Deporte"), Map.entry("C", "Cine"), Map.entry("TV","Televisión") ));
		m.put("view","t2/ej11/uno");
		return "_t/frame";	
	}
	
}

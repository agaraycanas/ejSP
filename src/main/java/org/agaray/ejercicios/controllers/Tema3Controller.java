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
@RequestMapping("/t3")
public class Tema3Controller {

	@GetMapping("ej12")
	public String ej12(ModelMap m) {
		m.put("view", "t3/ej12/uno");
		return "_t/frame";
	}


}

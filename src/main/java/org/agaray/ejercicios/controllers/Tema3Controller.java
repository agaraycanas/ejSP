package org.agaray.ejercicios.controllers;

//import static java.util.Map.entry; 

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/t3")
public class Tema3Controller {

	@GetMapping("ej12 ej12/1")
	public String ej12_1(ModelMap m, HttpSession s) {
		s.invalidate();
		m.put("view", "t3/ej12/uno");
		return "_t/frame";
	}
	
	@PostMapping("ej12/2")
	public String ej12_2(
			@RequestParam(value="nPasos",required = false) Integer nPasos,
			@RequestParam(value="n",required = false) Integer n,
			HttpSession s
			) {
			s.setAttribute("n", s.getAttribute("n")!=null ? s.getAttribute("n") : nPasos );
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}

package org.agaray.ejercicios.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/t4")
public class Tema4Controller {

	@GetMapping("ej1")
	public String ej1(ModelMap m) {
		m.put("view", "t4/ej01/formulario");
		return "_t/frame";
	}

	@GetMapping("ej1/a")
	public String ej1AJAX() {
		return "t4/ej01/ajax";
	}
}

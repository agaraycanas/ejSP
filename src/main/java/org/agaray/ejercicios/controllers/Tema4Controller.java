package org.agaray.ejercicios.controllers;


import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/t4")
public class Tema4Controller {

	@GetMapping("ej1")
	public String ej1(ModelMap m) {
		m.put("view", "t4/ej01/formulario");
		return "_t/frame";
	}

	@GetMapping("ej1/a")
	public String ej1AJAX(
			@RequestParam(value="nombre",required = false) String nombre,
			ModelMap m
			) {
		nombre = (nombre!=null ? nombre : "desconocido");
		m.put("mensaje", this.getMensaje(nombre));
		return "t4/ej01/ajax";
	}
	
	private String getMensaje(String nombre) {
		int num = (new Random()).nextInt(3);
		String ini = "";
		String fin = "";
		
		switch (num) {
			case 0: ini = "¡¡ Qué pasa";fin=" !!";break;
			case 1: ini ="Hola";break;
			case 2:ini = "Qué tal estás";break;
		}
		String mensaje = ini + " " + nombre + " " + fin;
		
		return mensaje;
	}
}

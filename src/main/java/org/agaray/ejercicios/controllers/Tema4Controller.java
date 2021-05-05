package org.agaray.ejercicios.controllers;


import java.util.Random;

import org.agaray.ejercicios.services.t4.ej02.T4Ej02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/t4")
public class Tema4Controller {
	
	@Autowired
	private T4Ej02Service service;
	
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
		
		int marca = ((new Random()).nextInt(3))+1;
		String mensaje = "<h" + marca + ">"+ ini + " " + nombre + " " + fin + "</h" + marca + ">";
		
		return mensaje;
	}

	@GetMapping("ej2")
	public String ej2() {
		service.init();
		return "t4/ej02/index";
	}
	
	@GetMapping("ej2/X-rp")
	 public String ej2AJAXrellenarProvincia(
			 @RequestParam(value="ccaa",required = false) String ccaa,
			 ModelMap m
			 ) {
	        ccaa = (ccaa!=null ? ccaa : "Andalucía");
	        m.put("provincias", service.getProvincias(ccaa));
	        return "t4/ej02/ajaxProvincias";
	 }
	
	@GetMapping("ej2/X-rccaa")
	public String ej2AJAXrellenarCCAA(
			ModelMap m
			) {
		m.put("ccaas",service.getCCAAs());
		return "t4/ej02/ajaxCCAA";
	}
	

}

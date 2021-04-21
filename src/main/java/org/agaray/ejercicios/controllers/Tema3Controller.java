package org.agaray.ejercicios.controllers;

import java.util.ArrayList;
import java.util.Arrays;

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

	@GetMapping("ej12")
	public String ej12_1(ModelMap m, HttpSession s) {
		s.invalidate();
		m.put("view", "t3/ej12/uno");
		return "_t/frame";
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("ej12/2")
	public String ej12_2(
			@RequestParam(value="nPasos",required = false) Integer nPasos,
			@RequestParam(value="n",required = false) Integer n,
			@RequestParam(value="sumando", required=false) Integer sumando,
			HttpSession s,
			ModelMap m
			) {
			
			String vista = "";
			
			s.setAttribute("n", s.getAttribute("n")!=null ? s.getAttribute("n") : 1 );
	        s.setAttribute("nTotal", s.getAttribute("nTotal")!=null ? s.getAttribute("nTotal") : nPasos );

	        
	        if (s.getAttribute("sumandos")!=null) {
	        	ArrayList<Integer> sumandos = ((ArrayList<Integer>)(s.getAttribute("sumandos")));
	        	sumandos.add(sumando);
	        	s.setAttribute("sumandos", sumandos );
	        }
	        else {
	        	s.setAttribute("sumandos", new ArrayList<Integer>());
	        }
	        
	        if ( (Integer)s.getAttribute("n") == ( (Integer)s.getAttribute("nTotal") ) + 1  ) {
	        	vista="redirect:/t3/ej12/3";
	        }
	        else {
	        	m.put("nActual", s.getAttribute("n"));
	        	m.put("nTotal", s.getAttribute("nTotal"));
	        	s.setAttribute("n",(Integer)(s.getAttribute("n")) + 1);
	        	m.put("view", "t3/ej12/dos");
	        	vista = "_t/frame";
	        }
	        
	        return vista;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("ej12/3")
	public String ej12_3(
			HttpSession s,
			ModelMap m
			) {
		m.put("sumandos",s.getAttribute("sumandos"));
		m.put("suma", this.sumar((ArrayList<Integer>)s.getAttribute("sumandos")));
		m.put("view", "t3/ej12/tres");
		return "_t/frame";
	}
	
	private int sumar(ArrayList<Integer> sumandos) {
		int sol = 0;
		//System.err.println(AL2String(sumandos));
		for ( int  sumando : sumandos) {
			sol += sumando;
		}
		return sol;
	}


}

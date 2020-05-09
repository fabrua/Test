package com.crud.h2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.h2.modelo.Persona;
import com.crud.h2.service.IPersonaService;

@Controller
public class PersonaController {
	@Autowired
	private IPersonaService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("personas",service.Listar());
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String nuevo() {
		return "agregar";
	}
	@PostMapping("/agregar")
	public String agregar(@Valid Persona p) {
		service.agregar(p);
		return "redirect:/listar";
	}
}
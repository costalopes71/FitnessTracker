package com.costalopes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.costalopes.model.Exercise;

@Controller
public class MinutesController {

	@RequestMapping(value="/addMinutes")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {
		
		System.out.println("exercise: " + exercise.getMinutes());
		
		// forward faz um bypass na ViewResolver e manda o request para outro mapeamento (metodo)
		// return "forward:addMoreMinutes.html";
		// faz redirect ou seja, um novo request para o mapeamento indicado
		// return "redirect:addMoreMinutes.html";
		
		return "addMinutes"; 
	}
	
	@RequestMapping(value="/addMoreMinutes")
	public String addMoreMinutes(@ModelAttribute("exercise") Exercise exercise) {
		
		System.out.println("exercising: " + exercise.getMinutes());
		
		return "addMinutes";
	}
	
}
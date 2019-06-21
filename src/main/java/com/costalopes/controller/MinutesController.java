package com.costalopes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.costalopes.model.Activity;
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

	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList<>();
		
		Activity run = new Activity();
		run.setDesc("Run");
		activities.add(run);
		
		Activity bike = new Activity();
		bike.setDesc("Bike");
		activities.add(bike);
		
		Activity swim = new Activity();
		swim.setDesc("Swim");
		activities.add(swim);
		
		return activities;
	}
	
}
package br.com.pet.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;


import br.com.pet.bean.Pet;
import br.com.pet.service.PetService;

@Controller
public class PetControllerWeb {
	
	@Autowired
	private PetService petService;
	
	@GetMapping("/")
	@ResponseBody
	public List<Pet> getHelloPet () {
		return petService.findAll();
		
	}
	
	
	
	
	
}
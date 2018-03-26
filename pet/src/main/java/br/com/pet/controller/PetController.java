package br.com.pet.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.number.PercentStyleFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pet.bean.Pet;
import br.com.pet.service.PetService;

@RestController
public class PetController {

	@Autowired
	private PetService petService;

	@GetMapping("/pet")
	public List<Pet> findAll() {

		return petService.findAll();

	}

	@PostMapping("/pet")
	public boolean create(@RequestParam Map<String, String> allRequestParams) {

		String nome = allRequestParams.get("nome");

		String numeroTagAsString = allRequestParams.get("numeroTag");
		int numeroTag = Integer.parseInt(numeroTagAsString);

		String raca = allRequestParams.get("raca");
		
		String sexoAsString = allRequestParams.get("sexo");
		char sexo = sexoAsString.charAt(0);

		String dataNascimentoAsString = allRequestParams.get("dataNascimento");
		LocalDate dataNascimento = LocalDate.parse(dataNascimentoAsString);

		String especie = allRequestParams.get("especie");

		String pelagem = allRequestParams.get("pelagem");

		String porte = allRequestParams.get("porte");

		Pet pet = new Pet(nome, numeroTag, raca, sexo, dataNascimento, especie, pelagem, porte);

		return petService.create(pet);

	}
	
	
	@DeleteMapping("/petDelete/{key}")
	public void delete(@PathVariable int key) {
		
		boolean containsKey = petService.containsKey(key);
		System.out.println(containsKey);
		if(containsKey) {
			petService.remove(key);
		}
		
		
		
		//int key = Integer.parseInt(keyAsString);
		System.out.println(key);
		
	}
	
	
	@PutMapping("/petUpdate/{key}")
	public void update(@RequestParam  Map<String, String> allRequestParams){
		
		String nome = allRequestParams.get("nome");

		String numeroTagAsString = allRequestParams.get("numeroTag");
		int numeroTag = Integer.parseInt(numeroTagAsString);

		String raca = allRequestParams.get("raca");
		
		String sexoAsString = allRequestParams.get("sexo");
		char sexo = sexoAsString.charAt(0);

		String dataNascimentoAsString = allRequestParams.get("dataNascimento");
		LocalDate dataNascimento = LocalDate.parse(dataNascimentoAsString);

		String especie = allRequestParams.get("especie");

		String pelagem = allRequestParams.get("pelagem");

		String porte = allRequestParams.get("porte");

		Pet pet = new Pet(nome, numeroTag, raca, sexo, dataNascimento, especie, pelagem, porte);
		
		boolean containsKey = petService.containsKey(numeroTag);
		
		if(containsKey) {
			petService.update(pet);
		}
		 
	}
	
	@GetMapping("/findPet/{key}")
	public Pet findPetByKey(@PathVariable int key){
		
		Pet pet = petService.findByKey(key);
				
		return pet;
	}
	

}

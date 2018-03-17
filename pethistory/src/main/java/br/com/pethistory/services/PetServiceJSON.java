package br.com.pethistory.services;

import java.util.HashMap;
import java.util.Map;

import br.com.pethistory.domain.Pet;

public class PetServiceJSON {
	
	private static final Map<Integer, Pet> mapping = new HashMap<>();

	Pet pet;

	public void save(Pet pet) {
		

		int petId= pet.getKey();

		pet.setPetId(petId);
		
		mapping.put(petId, pet);

	}
	
	public Map<Integer, Pet> findAll() {
		
		return mapping;
	}
	
	public void edit(int petId, Pet pet) {

		mapping.put(petId, pet);

	}
	
	public void delete(int petId) {

		mapping.remove(petId);

	}
	

}

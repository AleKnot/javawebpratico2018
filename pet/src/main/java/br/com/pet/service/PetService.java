package br.com.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pet.bean.Pet;
import br.com.pet.repository.PetRepository;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;

	public List<Pet> findAll() {
		return petRepository.findAll();

	}

	public boolean create(Pet pet) {
		return petRepository.create(pet);
	}

	public boolean remove(int key) {
		boolean wasRemoved = petRepository.remove(key);

		return wasRemoved;

	}

	public boolean update(Pet pet) {
		boolean wasUpdated = petRepository.update(pet);
		return wasUpdated; 

	}

	public boolean containsKey(int key) {
		return petRepository.containsKey(key);
	}
	
	public Pet findByKey(int key) {
		return petRepository.findByKey(key);
	}

}

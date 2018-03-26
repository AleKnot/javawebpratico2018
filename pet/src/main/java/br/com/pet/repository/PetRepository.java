package br.com.pet.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.pet.bean.Pet;


@Repository
public class PetRepository {

	// private static List<Pet> list = new ArrayList<>();
	private static final Map<Integer, Pet> PETMAP = new HashMap<>();

	public List<Pet> findAll() {
		return new ArrayList<>(PETMAP.values());

	}

	public boolean create(Pet pet) {

		boolean canCreate = !PETMAP.containsKey(pet.getKey());

		if (canCreate) {
			PETMAP.put(pet.getKey(), pet);
		}

		return canCreate;
	}

	public boolean remove(int key) {

		boolean canRemove = PETMAP.containsKey(key);

		if (canRemove) {
			PETMAP.remove(key);
		}

		return canRemove;
	}

	public boolean containsKey(int key) {
		return PETMAP.containsKey(key);

	}
	
	public Pet findByKey(int key) {
		return PETMAP.getOrDefault(key, null);
	}

	public boolean update(Pet pet) {
		
		boolean canUpdate = PETMAP.containsKey(pet.getKey());
		
		if(canUpdate) {
			
			PETMAP.put(pet.getKey(), pet);
		}
		
		return canUpdate;
	}

}

package org.springframework.samples.petclinic.adoption;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.pet.Pet;

public interface AdoptionRepository extends CrudRepository<Adoption, Integer> {

	// Consulta que devolverá la lista de todas las mascotas pendientes de adopción
	@Query("SELECT p FROM Pet p WHERE p.onAdoption = TRUE")
	public List<Pet> findPetsOnAdoption();

}

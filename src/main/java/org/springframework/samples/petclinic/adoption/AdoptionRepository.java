package org.springframework.samples.petclinic.adoption;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.pet.Pet;

public interface AdoptionRepository extends CrudRepository<AdoptionRequest, Integer> {

	// Consulta que devolverá la lista de todas las mascotas pendientes de adopción
	@Query("SELECT p FROM Pet p WHERE p.onAdoption = TRUE")
	public List<Pet> findPetsOnAdoption();

	@Query("SELECT ar FROM AdoptionRequest ar WHERE ar.originalOwner.id = ?1 AND ar.active = TRUE")
	public List<AdoptionRequest> findAllByOriginalOwner(Integer id);

	// Consulta que devolverá la lista de todas las solicitudes de una misma mascota que estén activas
	@Query("SELECT ar FROM AdoptionRequest ar WHERE ar.petToAdopt.id = ?1 AND ar.active = TRUE")
	public List<AdoptionRequest> findAllByPetToAdopt(Integer petId);

}

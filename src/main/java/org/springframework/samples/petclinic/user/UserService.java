/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.user;

import java.util.*;

import jakarta.security.auth.message.AuthException;
import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.clinic.Clinic;
import org.springframework.samples.petclinic.clinicowner.ClinicOwner;
import org.springframework.samples.petclinic.exceptions.ResourceNotFoundException;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetRepository;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.VetService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	private UserRepository userRepository;

//	private OwnerService ownerService;

	private PetRepository petRepository;
//
	private VetService vetService;

	@Autowired
	public UserService(UserRepository userRepository, VetService vetService, PetRepository petRepository) {
		this.userRepository = userRepository;
//		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petRepository = petRepository;
	}

	@Transactional
	public User saveUser(User user) throws DataAccessException {
		userRepository.save(user);
		return user;
	}

	@Transactional(readOnly = true)
	public User findUser(String username) {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
	}

	@Transactional(readOnly = true)
	public User findUser(Integer id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	}

	@Transactional(readOnly = true)
	public Owner findOwnerByUser(String username) {
		return userRepository.findOwnerByUser(username)
				.orElseThrow(() -> new ResourceNotFoundException("Owner", "username", username));
	}

	@Transactional(readOnly = true)
	public Vet findVetByUser(int userId) {
		return userRepository.findVetByUser(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Vet", "id", userId));
	}

	@Transactional(readOnly = true)
	public Owner findOwnerByUser(int id) {
		return userRepository.findOwnerByUser(id).orElseThrow(() -> new ResourceNotFoundException("Owner", "ID", id));
	}

	@Transactional(readOnly = true)
	public User findCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null)
			throw new ResourceNotFoundException("Nobody authenticated!");
		else
			return userRepository.findByUsername(auth.getName())
					.orElseThrow(() -> new ResourceNotFoundException("User", "Username", auth.getName()));
	}

	public Boolean existsUser(String username) {
		return userRepository.existsByUsername(username);
	}

	@Transactional(readOnly = true)
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	public Iterable<User> findAllByAuthority(String auth) {
		return userRepository.findAllByAuthority(auth);
	}

	@Transactional
	public User updateUser(@Valid User user, Integer idToUpdate) {
		User toUpdate = findUser(idToUpdate);
		BeanUtils.copyProperties(user, toUpdate, "id");
		userRepository.save(toUpdate);

		return toUpdate;
	}

	@Transactional
	public void deleteUser(Integer id) {
		User toDelete = findUser(id);
		deleteRelations(id, toDelete.getAuthority().getAuthority());
//		this.userRepository.deleteOwnerRelation(id);
//		this.userRepository.deleteVetRelation(id);
		this.userRepository.delete(toDelete);
	}

	private void deleteRelations(Integer id, String auth) {
		switch (auth) {
		case "OWNER":
//			Optional<Owner> owner = ownerService.optFindOwnerByUser(id);
//			if (owner.isPresent())
//				ownerService.deleteOwner(owner.get().getId());
			this.userRepository.deleteOwnerRelation(id);
			break;
		case "VET":
			Optional<Vet> vet = vetService.optFindVetByUser(id);
			if (vet.isPresent()) {
				vetService.deleteVet(vet.get().getId());
			}
			break;
		default:
			// The only relations that have user are Owner and Vet
			break;
		}

	}

	private Map<String, Object> findOwnerContext(Owner owner, String username) {

		Map<String, Object> context = new HashMap<>();

		List<Pet> pets = petRepository.findAllPetsByOwnerId(owner.getId());

		context.put("username", username);
		context.put("pets", pets.size());
		context.put("visits", 0);

		return context;
	}

	private Map<String, Object> findClinicOwnerContext(ClinicOwner clinicOwner, String username) {
		Map<String, Object> context = new HashMap<>();

		context.put("username", username);

		return context;
	}

	private Map<String, Object> findPublicContext() {

		Map<String, Object> featureMap = new HashMap<>();

		featureMap.put("public", true);

		return featureMap;
	}

    @Transactional(readOnly = true)
	public Map<String, Object> findUserContext() throws AuthException {

		User user = null;

		try {
			user = findCurrentUser();
		} catch (ResourceNotFoundException e) {
			System.out.println("User not found");
			return findPublicContext();
		}

		switch (user.getAuthority().getAuthority()) {
			case "OWNER":
				Owner owner = findOwnerByUser(user.getId());
				return findOwnerContext(owner, user.getUsername());
			case "CLINIC_OWNER":
				ClinicOwner clinicOwner = findClinicOwnerByUser(user.getId());
				return findClinicOwnerContext(clinicOwner, user.getUsername());
			default:
				throw new AuthException("Invalid role");
		}
	}

	@Transactional(readOnly = true)
	public ClinicOwner findClinicOwnerByUser(int userId) {
		return userRepository.findClinicOwnerByUser(userId)
				.orElseThrow(() -> new ResourceNotFoundException("ClinicOwner", "id", userId));
	}

    private String findMaxPlanByClinicOwner(ClinicOwner clinicOwner){
        String maxPlan = "BASIC";
        Set<Clinic> clinics = clinicOwner.getClinics();

        if(clinics.stream().anyMatch(c -> c.getPlan().toString().equals("PLATINUM")))
            maxPlan = "PLATINUM";
        else if(clinics.stream().anyMatch(c -> c.getPlan().toString().equals("GOLD")))
            maxPlan = "GOLD";

        return  maxPlan;
    }

	@Transactional(readOnly = true)
	public String findUserPlan() throws AuthException {

		User user = null;

		try {
			user = findCurrentUser();
		} catch (ResourceNotFoundException e) {
			System.out.println("User not found");
			return null;
		}

		switch (user.getAuthority().getAuthority()) {
			case "OWNER":
				Owner owner = findOwnerByUser(user.getId());
				return owner.getClinic().getPlan().toString();
			case "CLINIC_OWNER":
                ClinicOwner clinicOwner = findClinicOwnerByUser(user.getId());
                return findMaxPlanByClinicOwner(clinicOwner);
			default:
				throw new AuthException("Invalid role");
		}
	}
}

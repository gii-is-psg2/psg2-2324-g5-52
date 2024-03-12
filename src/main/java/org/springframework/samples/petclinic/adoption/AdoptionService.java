package org.springframework.samples.petclinic.adoption;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.samples.petclinic.user.User;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;

@Service
public class AdoptionService {
    private AdoptionRepository adoptionRepository;
    private OwnerService ownerService;
    private PetService petService;

    @Autowired
	public AdoptionService(AdoptionRepository adoptionRepository, OwnerService ownerService, PetService petService) {
		this.adoptionRepository = adoptionRepository;
        this.ownerService = ownerService;
        this.petService = petService;
	}

    @Transactional(readOnly = true)
    public List<AdoptionRequest> findAll() throws DataAccessException {
        return (List<AdoptionRequest>) adoptionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<AdoptionRequest> findAllByOriginalOwner(Integer userId) throws DataAccessException {
        Optional<Owner> owner = ownerService.optFindOwnerByUser(userId);
        if(owner.isPresent()){
            return (List<AdoptionRequest>) adoptionRepository.findAllByOriginalOwner(owner.get().getId());
        }
        else{
            throw new DataAccessException("Owner not found"){};
        }
    }

    @Transactional
	public AdoptionRequest save(AdoptionRequestForm adoptionRequestForm, User userNewOwner) throws DataAccessException {
        Optional<Owner> newOwner = ownerService.optFindOwnerByUser(userNewOwner.getId());
        if(!newOwner.isPresent()){
            throw new DataAccessException("The user is not an owner"){};
        }

        Pet pet = petService.findPetById(adoptionRequestForm.getPetId());
        if(pet.getOwner().getId() == newOwner.get().getId()){
            throw new DataAccessException("You cannot adopt your own pet"){};
        }
        if(!pet.getOnAdoption()){
            throw new DataAccessException("Pet is not on adoption"){};
        }
        
        AdoptionRequest adoptionRequest = new AdoptionRequest();
        adoptionRequest.setOriginalOwner(pet.getOwner());
        adoptionRequest.setNewOwner(newOwner.get());
        adoptionRequest.setPetToAdopt(pet);
        adoptionRequest.setDescription(adoptionRequestForm.getDescription());
        adoptionRepository.save(adoptionRequest);

        return adoptionRequest;
	}

    @Transactional
    public AdoptionRequest acceptAdoptionRequest(Integer requestId, User userId) throws DataAccessException {

        Optional<Owner> originalOwner = ownerService.optFindOwnerByUser(userId.getId());
        if(!originalOwner.isPresent()){
            throw new DataAccessException("The user is not an owner"){};
        }

        Optional<AdoptionRequest> adoptionRequest = adoptionRepository.findById(requestId);
        if(!adoptionRequest.isPresent()){
            throw new DataAccessException("Adoption Request not found"){};
        }
        AdoptionRequest adoptionRequestToAccept = adoptionRequest.get();

        if(adoptionRequestToAccept.getOriginalOwner().getId() != originalOwner.get().getId()){
            throw new DataAccessException("You are not the original owner of the pet"){};
        }

        Pet pet = adoptionRequestToAccept.getPetToAdopt();
        pet.setOnAdoption(false);
        pet.setOwner(adoptionRequestToAccept.getNewOwner());
        petService.savePet(pet);

        adoptionRequestToAccept.setAdmitted(true);
        adoptionRequestToAccept.setActive(false);

        return adoptionRepository.save(adoptionRequestToAccept);
    }

}

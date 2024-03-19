package org.springframework.samples.petclinic.petHotelRoom;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.clinic.Clinic;
import org.springframework.samples.petclinic.clinic.ClinicService;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.samples.petclinic.petHotelRoom.booking.Booking;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class PetHotelRoomService {
    
    private PetHotelRoomRepository petHotelRoomRepository;
    private PetService petService;
    private ClinicService clinicService;

    public PetHotelRoomService(PetHotelRoomRepository petHotelRoomRepository, PetService petService, ClinicService clinicService) {
        this.petHotelRoomRepository = petHotelRoomRepository;
        this.petService = petService;
        this.clinicService = clinicService;
    }


    public PetHotelRoom savePetHotelRoom(PetHotelRoomCreationRequest petHotelRoomRequest) {
        PetHotelRoom newPetHotelRoom = new PetHotelRoom();
		newPetHotelRoom.setName(petHotelRoomRequest.getName());
		newPetHotelRoom.setSize(petHotelRoomRequest.getSize());
        newPetHotelRoom.setRoomNumber(petHotelRoomRepository.findAll().size() + 1);

        PetType petType = petService.findPetTypeByName(petHotelRoomRequest.getPetType());
        newPetHotelRoom.setPetType(petType);

        Clinic clinic = clinicService.findClinicByName(petHotelRoomRequest.getClinic());
        newPetHotelRoom.setClinic(clinic);
    

        return petHotelRoomRepository.save(newPetHotelRoom);
    }

    @Transactional(readOnly = true)
    public List<PetHotelRoom> findFreeRooms() {
        return petHotelRoomRepository.findFreeRooms();
    }

    @Transactional(readOnly = true)
    public List<PetHotelRoom> findAll() {
        return petHotelRoomRepository.findAll();
    }

    @Transactional(readOnly = true)
    public PetHotelRoom save(PetHotelRoom petHotelRoom){
        petHotelRoomRepository.save(petHotelRoom);
        return petHotelRoom;
    }

    @Transactional(readOnly = true)
	public PetHotelRoom update(PetHotelRoom petHotelRoom, Integer id) throws DataAccessException{
		if (petHotelRoomRepository.findById(id).isEmpty())
			throw new DataAccessException("Non existing booking"){
		};
		PetHotelRoom toUpdate = petHotelRoomRepository.findById(id) == null ? petHotelRoomRepository.findById(id).get() : null;
		BeanUtils.copyProperties(petHotelRoom, toUpdate, "id");
		return save(toUpdate);

	}

}

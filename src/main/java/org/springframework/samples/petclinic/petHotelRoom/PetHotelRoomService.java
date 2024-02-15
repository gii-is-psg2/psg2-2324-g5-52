package org.springframework.samples.petclinic.petHotelRoom;

import java.util.List;

import org.springframework.samples.petclinic.clinic.Clinic;
import org.springframework.samples.petclinic.clinic.ClinicService;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.NotNull;

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

        PetType petType = petService.findPetTypeByName(petHotelRoomRequest.getPetType());
        newPetHotelRoom.setPetType(petType);

        Clinic clinic = clinicService.findClinicByName(petHotelRoomRequest.getClinic());
        newPetHotelRoom.setClinic(clinic);
    

        return petHotelRoomRepository.save(newPetHotelRoom);
    }

    public List<PetHotelRoom> findAll() {
        Iterable<PetHotelRoom> petHotelRooms = petHotelRoomRepository.findAll();
        return (List<PetHotelRoom>) petHotelRooms;
    }

}

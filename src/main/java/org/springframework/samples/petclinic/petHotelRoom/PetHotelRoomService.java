package org.springframework.samples.petclinic.petHotelRoom;

import org.springframework.stereotype.Service;

@Service
public class PetHotelRoomService {
    
    private PetHotelRoomRepository petHotelRoomRepository;

    public PetHotelRoomService(PetHotelRoomRepository petHotelRoomRepository) {
        this.petHotelRoomRepository = petHotelRoomRepository;
    }
    public void savePetHotelRoom(PetHotelRoom petHotelRoom) {
        petHotelRoomRepository.save(petHotelRoom);
    }

    public List<PetHotelRoom> findAll() {
        return petHotelRoomRepository.findAll();
    }

}

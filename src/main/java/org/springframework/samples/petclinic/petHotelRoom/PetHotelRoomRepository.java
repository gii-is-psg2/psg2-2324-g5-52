package org.springframework.samples.petclinic.petHotelRoom;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetHotelRoomRepository extends CrudRepository<PetHotelRoom, Integer>{
    
    
}

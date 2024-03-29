package org.springframework.samples.petclinic.petHotelRoom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetHotelRoomRepository extends CrudRepository<PetHotelRoom, Integer>{
    
    @Query("SELECT p FROM PetHotelRoom p WHERE p.busy = false")
    List<PetHotelRoom> findFreeRooms();

    List<PetHotelRoom> findAll();

    Optional<PetHotelRoom> findById(Integer id);
}

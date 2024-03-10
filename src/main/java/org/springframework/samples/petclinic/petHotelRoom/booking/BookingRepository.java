package org.springframework.samples.petclinic.petHotelRoom.booking;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.pet.Pet;

public interface BookingRepository extends CrudRepository<Booking,Integer> {

    @Query("SELECT b FROM Booking b WHERE (b.petHotelRoom.id = :roomId OR b.pet.id = :petId) AND ((b.endDate > :startDate AND  b.startDate < :startDate) OR (b.startDate < :endDate AND b.endDate > :endDate) OR (b.startDate >= :startDate AND b.endDate <= :endDate) OR (b.startDate < :startDate AND b.endDate > :endDate))")
    List<Booking> findConcurrentBooking(Pet petId, Integer roomId, LocalDate startDate, LocalDate endDate);

    @Query("SELECT b FROM Booking b WHERE b.pet.id = :petId")
    List<Booking> findByPetId(int petId);

    @Query("SELECT b FROM Booking b WHERE b.petHotelRoom.id = :roomId")
    List<Booking> findByRoomId(int roomId);

    @Query("SELECT b FROM Booking b WHERE b.pet.owner.id = :ownerId")
    List<Booking> findByOwnerId(int ownerId);
    
    //@Query("SELECT b FROM Booking b WHERE (b.hotelRoom.id = :roomid OR b.pet.id = :petid) AND NOT (:startDate BETWEEN b.startDate AND b.endDate) AND  NOT (:endDate BETWEEN b.startDate AND b.endDate)")
    //List<Booking> findConcurrentBooking(Pet petId, PetHotelRoom roomId, LocalDate startDate, LocalDate endDate);
}

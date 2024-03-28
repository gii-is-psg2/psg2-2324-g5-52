package org.springframework.samples.petclinic.petHotelRoom.booking;

import java.time.LocalDate;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.petHotelRoom.PetHotelRoom;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Booking extends BaseEntity{

    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate startDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate endDate;

    @Valid
    @ManyToOne(optional = false)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Valid
    @ManyToOne(optional = false)
    @JoinColumn(name = "pet_hotel_room_id")
    private PetHotelRoom petHotelRoom;

    
}

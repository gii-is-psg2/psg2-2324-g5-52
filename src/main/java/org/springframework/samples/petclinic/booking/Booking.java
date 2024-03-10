package org.springframework.samples.petclinic.booking;

import java.time.LocalDate;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.petHotelRoom.PetHotelRoom;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Booking extends BaseEntity{

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate endDate;

    @Valid
    @ManyToOne(optional = true)
    private Pet pet;

    @Valid
    @ManyToOne(optional = true)
    private PetHotelRoom petHotelRoom;

    
}

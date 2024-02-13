package org.springframework.samples.petclinic.petHotelRoom;

import org.springframework.samples.petclinic.clinic.Clinic;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PetHotelRoom extends BaseEntity{

    String name; 

    @ManyToOne
    PetType petType;

    @ManyToOne
    Clinic clinic;

    Integer size;

    
}
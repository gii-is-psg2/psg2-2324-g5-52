package org.springframework.samples.petclinic.petHotelRoom;

import org.springframework.samples.petclinic.clinic.Clinic;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PetHotelRoom extends BaseEntity{

    @NotBlank
    String name; 

    @NotNull
    @Max(50)
    @Min(0)
    int roomNumber;

    @ManyToOne
    @NotNull
    @Valid
    PetType petType;

    @ManyToOne(optional = false)
    @Valid
    @NotNull
    Clinic clinic;

    @Min(0)
    int size;

    @NotNull
    Boolean busy = false;
    
}
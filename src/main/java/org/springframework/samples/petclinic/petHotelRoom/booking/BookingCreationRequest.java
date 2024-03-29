package org.springframework.samples.petclinic.petHotelRoom.booking;

import java.time.LocalDate;

import org.springframework.samples.petclinic.petHotelRoom.PetHotelRoom;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingCreationRequest {


    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotBlank
    private String pet;

    @NotNull
    private PetHotelRoom petHotelRoom;

    
    
}

package org.springframework.samples.petclinic.petHotelRoom;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetHotelRoomCreationRequest {
	
	@NotBlank
	private String name;

	@NotBlank
	private String clinic;

    @NotBlank
	private String petType;

	private Integer size;

}

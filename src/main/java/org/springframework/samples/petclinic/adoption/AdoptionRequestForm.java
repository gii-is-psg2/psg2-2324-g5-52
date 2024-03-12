package org.springframework.samples.petclinic.adoption;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdoptionRequestForm {
    @NotBlank
	private String description;

	@NotNull
	private Integer petId;

}

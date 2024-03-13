package org.springframework.samples.petclinic.adoption;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdoptionRequestForm {
    @NotBlank
	@Length(max = 255)
	private String description;

	@NotNull
	private Integer petId;

}

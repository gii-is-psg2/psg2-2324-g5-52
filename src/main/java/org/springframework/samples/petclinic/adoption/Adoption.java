package org.springframework.samples.petclinic.adoption;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Adoption extends BaseEntity{

    @ManyToOne
    private Owner originalOwner;

    @ManyToOne
    private Owner newOwner;

    @ManyToOne
    private Pet petToAdopt;

    // Indicará si la adopción ha sido aceptada por originalOwner y está por tanto Activa
    private Boolean active;

    // Descripción que añadirá newOwner a la solicitud, para que originalOwner le acepte la adopción
    private String description;
    
}
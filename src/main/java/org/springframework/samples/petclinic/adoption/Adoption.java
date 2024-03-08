package org.springframework.samples.petclinic.adoption;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "adoptions")
@Getter
@Setter
public class Adoption extends BaseEntity{

    @Column(name = "original_owner")
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    @NotNull
    private Owner originalOwner;

    @Column(name = "new_owner")
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    @NotNull
    private Owner newOwner;

    @Column(name = "pet_to_adopt")
    @ManyToOne(optional = false)
    @JoinColumn(name = "pet_id")
    @NotNull
    private Pet petToAdopt;

    // Indicará si la adopción ha sido aceptada por originalOwner y está por tanto Activa
    @Column(name = "active")
    @NotNull
    private Boolean active = true;

    // Descripción que añadirá newOwner a la solicitud, para que originalOwner le acepte la adopción
    @Column(name = "description", length = 100)
    @NotEmpty
    private String description;
    
}
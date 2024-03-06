package org.springframework.samples.petclinic.adoptions;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Adoption extends BaseEntity{

    @OneToMany
    private Owner originalOwner;

    @OneToMany
    private Owner newOwner;

    @OneToMany
    private Pet petToAdopt;
    
}
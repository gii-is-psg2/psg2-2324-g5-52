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
@Table(name = "adoption_requests")
@Getter
@Setter
public class AdoptionRequests extends BaseEntity{

    @Column(name = "original_owner_id")
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    @NotNull
    private Owner originalOwner;

    @Column(name = "new_owner_id")
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    @NotNull
    private Owner newOwner;

    @Column(name = "pet_to_adopt_id")
    @ManyToOne(optional = false)
    @JoinColumn(name = "pet_id")
    @NotNull
    private Pet petToAdopt;

    // Indicará las solicitudes actualmente activas sobre esta mascota, por si en un 
    // futuro vuelve a ser objeto de otra adopción no aparezcan de nuevo estas solicitudes
    // ya marcadas a false terminado el actual proceso de adopción
    @Column(name = "active")
    @NotNull
    private Boolean active = true;

    // Indicará si esta solicitud de adopción ha sido aceptada o admitida por originalOwner 
    // de entre las distintas solicitudes de adopción sobre su mascota. Por defecto, ninguna 
    // solicitud de adopción nueva que se cree estará admitida.
    @Column(name = "admitted")
    @NotNull
    private Boolean admitted = false;

    // Descripción que añadirá newOwner a la solicitud, para que originalOwner le acepte la adopción
    @Column(name = "description", length = 255)
    @NotEmpty
    private String description;
    
}
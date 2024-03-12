package org.springframework.samples.petclinic.adoption;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.samples.petclinic.user.User;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/adoptions")
@Tag(name = "Adoptions", description = "The Adoptions managemet API")
@SecurityRequirement(name = "bearerAuth")
public class AdoptionRestController {
    private final AdoptionService adoptionService;
    private final UserService userService;

	@Autowired
	public AdoptionRestController(AdoptionService adoptionService, UserService userService) {
		this.adoptionService = adoptionService;
        this.userService = userService;
	}

    @GetMapping
	public ResponseEntity<?> findMyAdoptionRequests() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUser(auth.getName());
        try{
            List<AdoptionRequest> adoptionRequests = adoptionService.findAllByOriginalOwner(user.getId());
            return new ResponseEntity<>(adoptionRequests, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
	}

    @PutMapping("/accept/{id}")
	public ResponseEntity<?> acceptAdoptionRequest(@PathVariable("id") int id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUser(auth.getName());
        try{
            AdoptionRequest adoptionRequests = adoptionService.acceptAdoptionRequest(id,user);
            return new ResponseEntity<>(adoptionRequests, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
	}

    @PostMapping
	public ResponseEntity<?> createAdoptionRequest(@RequestBody @Valid AdoptionRequestForm adoptionRequestForm) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUser(auth.getName());
        try {
            AdoptionRequest adoptionRequestSaved = adoptionService.save(adoptionRequestForm,user);
            return new ResponseEntity<>(adoptionRequestSaved, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
	}


}

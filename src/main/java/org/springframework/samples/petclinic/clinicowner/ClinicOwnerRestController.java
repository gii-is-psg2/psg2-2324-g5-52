package org.springframework.samples.petclinic.clinicowner;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.auth.payload.response.MessageResponse;
import org.springframework.samples.petclinic.petHotelRoom.PetHotelRoom;
import org.springframework.samples.petclinic.petHotelRoom.PetHotelRoomCreationRequest;
import org.springframework.samples.petclinic.petHotelRoom.PetHotelRoomService;
import org.springframework.samples.petclinic.petHotelRoom.booking.Booking;
import org.springframework.samples.petclinic.petHotelRoom.booking.BookingCreationRequest;
import org.springframework.samples.petclinic.petHotelRoom.booking.BookingService;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/clinicOwners")
@SecurityRequirement(name = "bearerAuth")
public class ClinicOwnerRestController {
	private final ClinicOwnerService clinicOwnerService;
	private final UserService userService;
	private final PetHotelRoomService petHotelRoomService;
	private final BookingService bookingService;

	@Autowired
	public ClinicOwnerRestController(ClinicOwnerService clinicOwnerService, UserService userService,
			PetHotelRoomService petHotelRoomService, BookingService bookingService) {
		this.clinicOwnerService = clinicOwnerService;
		this.userService = userService;
		this.petHotelRoomService = petHotelRoomService;
		this.bookingService = bookingService;

	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<ClinicOwner>> getAll() {
		return new ResponseEntity<>((List<ClinicOwner>) clinicOwnerService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/clinics")
	public ResponseEntity<ClinicOwner> findByUserId(@RequestParam(required = true) Integer userId) {
		return new ResponseEntity<>(clinicOwnerService.findByUserId(userId), HttpStatus.OK);
	}

	@GetMapping(value = "/{clinicOwnerId}")
	public ResponseEntity<ClinicOwner> getClinicOwnerById(@PathVariable("clinicOwnerId") int clinicOwnerId) {
		return new ResponseEntity<>(clinicOwnerService.findById(clinicOwnerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ClinicOwner> create(@Valid @RequestBody ClinicOwner clinicOwner,
			@RequestParam(required = false) int userId) {

		System.out.println("ID: " + userId);

		User user = userService.findUser(userId);
		clinicOwner.setUser(user);

		clinicOwnerService.saveClinicOwner(clinicOwner);
		return new ResponseEntity<>(clinicOwner, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{clinicOwnerId}")
	public ResponseEntity<ClinicOwner> create(@PathVariable("clinicOwnerId") int clinicOwnerId,
			@Valid @RequestBody ClinicOwner clinicOwner) {

		ClinicOwner clinicOwnerToUpdate = clinicOwnerService.findById(clinicOwnerId);
		BeanUtils.copyProperties(clinicOwner, clinicOwnerToUpdate, "id", "user", "clinics");

		return new ResponseEntity<>(clinicOwnerService.saveClinicOwner(clinicOwnerToUpdate), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{clinicOwnerId}")
	public ResponseEntity<MessageResponse> delete(@PathVariable("clinicOwnerId") int clinicOwnerId) {
		clinicOwnerService.deleteById(clinicOwnerId);
		return new ResponseEntity<>(new MessageResponse("Clinic Owner deleted successfully!"), HttpStatus.OK);
	}

	@GetMapping(value = "petHotelRooms")
	public ResponseEntity<List<PetHotelRoom>> getPetHotelRooms() {
		return new ResponseEntity<>(petHotelRoomService.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = "petHotelRooms")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PetHotelRoom> createPetHotelRoom(
			@RequestBody @Valid PetHotelRoomCreationRequest petHotelRoomRequest) throws URISyntaxException {
		PetHotelRoom savedPetHotelRoom = this.petHotelRoomService.savePetHotelRoom(petHotelRoomRequest);

		return new ResponseEntity<>(savedPetHotelRoom, HttpStatus.CREATED);
	}

	@PostMapping(value = "bookings")
	public ResponseEntity<?> createbooking(@RequestBody @Valid BookingCreationRequest bookingCreationRequest)
			throws DataAccessException {
		try {
			bookingService.save(bookingCreationRequest);
			return new ResponseEntity<>(bookingCreationRequest, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "bookings")
	public ResponseEntity<List<Booking>> findAllbookings() {
		return new ResponseEntity<>(bookingService.findAll(), HttpStatus.OK);
	}

}
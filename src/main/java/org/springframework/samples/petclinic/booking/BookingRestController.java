package org.springframework.samples.petclinic.booking;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.auth.payload.response.MessageResponse;
import org.springframework.samples.petclinic.util.RestPreconditions;


@RestController
@RequestMapping("/api/v1/bookings")
public class BookingRestController {
    private final BookingService bookingService;

    @Autowired
	public BookingRestController(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@GetMapping
	public ResponseEntity<List<Booking>> findAllbookings(@RequestParam(required = false) Integer roomId,
	@RequestParam(required = false) Integer petId, @RequestParam(required = false) Integer ownerId) {
		
		if (roomId != null) {
			return new ResponseEntity<>(bookingService.findByRoomId(roomId), HttpStatus.OK);
		}
		if (petId != null) {
			return new ResponseEntity<>(bookingService.findByPetId(petId), HttpStatus.OK);
		}
		if (ownerId != null) {
			return new ResponseEntity<>(bookingService.findByOwnerId(ownerId), HttpStatus.OK);
		}
		return new ResponseEntity<>(bookingService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "{bookingId}")
	public ResponseEntity<Booking> findbookingById(@PathVariable("bookingId") int bookingId) {
		return new ResponseEntity<>(bookingService.findById(bookingId), HttpStatus.OK);
	}

    @PostMapping
	public ResponseEntity<Booking> createbooking(@RequestBody @Valid Booking booking) {
		Booking newbooking = new Booking();
		BeanUtils.copyProperties(booking, newbooking, "id");
		return new ResponseEntity<>(bookingService.save(newbooking), HttpStatus.CREATED);
	}

	@PutMapping(value = "{bookingId}")
	public ResponseEntity<Booking> updatebooking(@PathVariable("bookingId") int bookingId,
			@RequestBody @Valid Booking booking) {
		RestPreconditions.checkNotNull(bookingService.findById(bookingId), "booking", "ID", bookingId);
		return new ResponseEntity<>(bookingService.update(booking, bookingId), HttpStatus.OK);
	}

	@DeleteMapping(value = "{bookingId}")
	public ResponseEntity<MessageResponse> deleteBooking(@PathVariable("bookingId") int bookingId) {
		RestPreconditions.checkNotNull(bookingService.findById(bookingId), "booking", "ID", bookingId);
		bookingService.delete(bookingId);
		return new ResponseEntity<>(new MessageResponse("booking deleted!"), HttpStatus.OK);
	}
    
}

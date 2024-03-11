package org.springframework.samples.petclinic.petHotelRoom.booking;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.List;

import javax.naming.directory.InvalidAttributeValueException;

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
	public ResponseEntity<List<Booking>> findAllbookings() {
		return new ResponseEntity<>(bookingService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/pet/{petId}")
	public ResponseEntity<List<Booking>> findbookingsByPetId(@PathVariable("petId") int petId) {
		return new ResponseEntity<>(bookingService.findByPetId(petId), HttpStatus.OK);
	}

	@GetMapping(value = "/room/{roomId}")
	public ResponseEntity<List<Booking>> findbookingsByRoomId(@PathVariable("roomId") int roomId) {
		return new ResponseEntity<>(bookingService.findByRoomId(roomId), HttpStatus.OK);
	}

	@GetMapping(value = "/owner/{ownerId}")
	public ResponseEntity<List<Booking>> findbookingsByOwnerId(@PathVariable("ownerId") int ownerId) {
		return new ResponseEntity<>(bookingService.findByOwnerId(ownerId), HttpStatus.OK);
	}

	@GetMapping(value = "{bookingId}")
	public ResponseEntity<Booking> findbookingById(@PathVariable("bookingId") int bookingId) {
		return new ResponseEntity<>(bookingService.findById(bookingId), HttpStatus.OK);
	}

    @PostMapping
	public ResponseEntity<Booking> createbooking(@RequestBody @Valid Booking booking) throws InvalidAttributeValueException{
		Booking newBooking = new Booking();
		BeanUtils.copyProperties(booking, newBooking, "id");
		return new ResponseEntity<>(bookingService.save(newBooking), HttpStatus.CREATED);
	}

	@PutMapping(value = "{bookingId}")
	public ResponseEntity<Booking> updatebooking(@PathVariable("bookingId") int bookingId,
			@RequestBody @Valid Booking booking) throws InvalidAttributeValueException{
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

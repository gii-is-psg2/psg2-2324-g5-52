package org.springframework.samples.petclinic.petHotelRoom.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;

@Service
public class BookingService {
	private BookingRepository bookingRepository;
	private PetService petService;

	@Autowired
	public BookingService(BookingRepository bookingRepository, PetService petService) {
		this.petService = petService;
		this.bookingRepository = bookingRepository;
	}

	@Transactional(readOnly = true)
	public List<Booking> findAll() {
		return (List<Booking>) bookingRepository.findAll();
	}


	@Transactional
	public Booking save(BookingCreationRequest bookingCreationRequest) throws DataAccessException {
		Booking newBooking = new Booking();
		newBooking.setStartDate(bookingCreationRequest.getStartDate());
		newBooking.setEndDate(bookingCreationRequest.getEndDate());
		Pet pet = petService.findPetByName(bookingCreationRequest.getPet());
		newBooking.setPet(pet);
		newBooking.setPetHotelRoom(bookingCreationRequest.getPetHotelRoom());

		List<Booking> bookingsConcurrentes = bookingRepository
				.findConcurrentBooking(newBooking.getPet().getId(), newBooking.getPetHotelRoom().getId(), newBooking.getStartDate(),
				bookingCreationRequest.getEndDate());
		if (bookingsConcurrentes.size() >= 1) {
			throw new DataAccessException("Concurrent booking found in the same room and date range.") {
			};

		}
		if (bookingCreationRequest.getStartDate().isAfter(bookingCreationRequest.getEndDate())) {
			throw new DataAccessException("The start date must be before the end date") {
			};
		} else {
			bookingRepository.save(newBooking);
			return newBooking;
		}
	}

}

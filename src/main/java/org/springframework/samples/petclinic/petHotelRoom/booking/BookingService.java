package org.springframework.samples.petclinic.petHotelRoom.booking;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;


@Service
public class BookingService {
    private BookingRepository bookingRepository;

    
    @Autowired
	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@Transactional(readOnly = true)
	public List<Booking> findAll() {
		return (List<Booking>) bookingRepository.findAll();
	}

    @Transactional(readOnly = true)
	public List<Booking> findByPetId(int petId) throws DataAccessException {
		if(bookingRepository.findByPetId(petId).isEmpty())
			throw new DataAccessException("No bookings found for this pet") {
		};
		return bookingRepository.findByPetId(petId);
	}

    @Transactional(readOnly = true)
	public List<Booking> findByRoomId(int roomId) throws DataAccessException {
		if(bookingRepository.findByRoomId(roomId).isEmpty())
			throw new DataAccessException("No bookings found for this room") {
		};
		return bookingRepository.findByRoomId(roomId);
	}

    @Transactional(readOnly = true)
	public List<Booking> findByOwnerId(int ownerId) throws DataAccessException {
		if(bookingRepository.findByRoomId(ownerId).isEmpty())
			throw new DataAccessException("No bookings found for this owner") {
		};
		return bookingRepository.findByRoomId(ownerId);
	}

    @Transactional(readOnly = true)
    public Booking findById(int bookingId) throws DataAccessException {
		if (!bookingRepository.findById(bookingId).isPresent())
			throw new DataAccessException("Non existing booking") {
		};
        return bookingRepository.findById(bookingId).get();
    }

    @Transactional
    public Booking save(Booking booking) throws DataAccessException {
        List<Booking> bookingsConcurrentes = bookingRepository
            .findConcurrentBooking(booking.getPet(), booking.getPetHotelRoom().getId(), booking.getStartDate(), booking.getEndDate());
        if (bookingsConcurrentes.size() >= 1) {
            throw new DataAccessException("Concurrent booking found in the same room and date range."){
			};

        } if(booking.getStartDate().isAfter(booking.getEndDate())){
			throw new DataAccessException("The start date must be before the end date"){
			};
		}	
		else {
            bookingRepository.save(booking);
            return booking;
        }
    }

    @Transactional
	public Booking update(Booking booking, int id) throws DataAccessException{
		if (bookingRepository.findById(id).isEmpty())
			throw new DataAccessException("Non existing booking"){
		};
		Booking toUpdate = findById(id);
		BeanUtils.copyProperties(booking, toUpdate, "id");
		return save(toUpdate);
	}

    @Transactional
	public void delete(int bookingId) throws DataAccessException {
		if (!bookingRepository.findById(bookingId).isPresent())
			throw new DataAccessException("Non existing booking") {
		};
		bookingRepository.deleteById(bookingId);
	}
}

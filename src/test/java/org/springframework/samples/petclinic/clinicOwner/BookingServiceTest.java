package org.springframework.samples.petclinic.clinicOwner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.samples.petclinic.petHotelRoom.booking.Booking;
import org.springframework.samples.petclinic.petHotelRoom.booking.BookingCreationRequest;
import org.springframework.samples.petclinic.petHotelRoom.booking.BookingRepository;
import org.springframework.samples.petclinic.petHotelRoom.booking.BookingService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class BookingServiceTest {

    private BookingService bookingService;
    private BookingRepository bookingRepository;
    private PetService petService;

    @BeforeEach
    void setup() {
        bookingRepository = mock(BookingRepository.class);
        petService = mock(PetService.class);
        bookingService = new BookingService(bookingRepository, petService);
    }

    @Test
    void testFindAll() {
        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking());
        bookings.add(new Booking());
        when(bookingRepository.findAll()).thenReturn(bookings);

        List<Booking> result = bookingService.findAll();

        assertEquals(2, result.size());
    }


}
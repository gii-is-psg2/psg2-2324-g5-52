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
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.samples.petclinic.petHotelRoom.PetHotelRoom;
import org.springframework.samples.petclinic.petHotelRoom.booking.Booking;
import org.springframework.samples.petclinic.petHotelRoom.booking.BookingCreationRequest;
import org.springframework.samples.petclinic.petHotelRoom.booking.BookingRepository;
import org.springframework.samples.petclinic.petHotelRoom.booking.BookingService;

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

    @Test
    void testSave_ValidBooking() {
        BookingCreationRequest request = new BookingCreationRequest();
        PetHotelRoom pHR = new PetHotelRoom();

        pHR.setName("Room 101");

        request.setStartDate(LocalDate.now().plusDays(1));
        request.setEndDate(LocalDate.now().plusDays(2));
        request.setPet("Test Pet");
        request.setPetHotelRoom(pHR);

        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Test Pet");

        when(petService.findPetByName(request.getPet())).thenReturn(pet);
        when(bookingRepository.findConcurrentBooking(1, 101, request.getStartDate(), request.getEndDate())).thenReturn(new ArrayList<>());

        Booking savedBooking = bookingService.save(request);

        assertEquals(request.getStartDate(), savedBooking.getStartDate());
        assertEquals(request.getEndDate(), savedBooking.getEndDate());
        assertEquals("Test Pet", savedBooking.getPet().getName());
        assertEquals("Room 101", savedBooking.getPetHotelRoom().getName());
    }

    @Test
    void testSave_ConcurrentBookingExists() {
        BookingCreationRequest request = new BookingCreationRequest();
        PetHotelRoom pHR = new PetHotelRoom();

        pHR.setName("Room 101");

        request.setStartDate(LocalDate.now().plusDays(1));
        request.setEndDate(LocalDate.now().plusDays(2));
        request.setPet("Test Pet");
        request.setPetHotelRoom(pHR);

        Pet pet = new Pet();
        pet.setId(1);
        when(petService.findPetByName(request.getPet())).thenReturn(pet);
        List<Booking> concurrentBookings = new ArrayList<>();
        concurrentBookings.add(new Booking());
        when(bookingRepository.findConcurrentBooking(1, 101, request.getStartDate(), request.getEndDate())).thenReturn(concurrentBookings);

        assertThrows(DataAccessException.class, () -> bookingService.save(request));
    }

    @Test
    void testSave_InvalidDates() {
        BookingCreationRequest request = new BookingCreationRequest();
        PetHotelRoom pHR = new PetHotelRoom();

        pHR.setName("Room 101");

        request.setStartDate(LocalDate.now().plusDays(2));
        request.setEndDate(LocalDate.now().plusDays(1));
        request.setPet("Test Pet");
        request.setPetHotelRoom(pHR);

        assertThrows(DataAccessException.class, () -> bookingService.save(request));
    }
}

/*
 * 
 * 
package org.springframework.samples.petclinic.clinicOwner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.samples.petclinic.petHotelRoom.booking.Booking;
import org.springframework.samples.petclinic.petHotelRoom.booking.BookingCreationRequest;
import org.springframework.samples.petclinic.petHotelRoom.booking.BookingRepository;
import org.springframework.samples.petclinic.petHotelRoom.booking.BookingService;
public class BookingServiceTest {
    @Mock
    private BookingRepository bookingRepository;
    @InjectMocks
    private BookingService bookingService;
    @InjectMocks
    private PetService petService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void findAllBookingTest() {
        Booking booking1 = new Booking();
        Booking booking2 = new Booking();
        List<Booking> expectedBookings = List.of(booking1, booking2);
        when(bookingRepository.findAll()).thenReturn(expectedBookings);
        List<Booking> actualBookings = bookingService.findAll();
        
        assertEquals(expectedBookings, actualBookings);
    }
    @Test
    public void saveBookingTest() {
        BookingCreationRequest bookingCreationRequest = new BookingCreationRequest();
        Booking booking = new Booking();
        when(bookingRepository.save(booking)).thenReturn(booking);
        Booking actualBookingCreationRequest = bookingService.save(bookingCreationRequest);
        
        assertEquals(bookingCreationRequest, actualBookingCreationRequest);
    }
    
}
 */
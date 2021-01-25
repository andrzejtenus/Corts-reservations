package courts.helpers.reservations;


import courts.repositories.ReservationsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class ReservationValidatorTest {

    @Mock
    ReservationsRepository reservationsRepository;

    @InjectMocks
    ReservationValidator reservationValidator;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void isReservationTakenValidation() {
        //given
        /*
        ReservationHelper reservation_= new ReservationHelper(null,
                null, new Time(11,0,0),
                new Time(12,0,0));

        Reservation reservation = new Reservation(reservation_,null,null);

        //reservation ends before new reservation
        ReservationForm reservationToValid = new ReservationForm(null,
                null, new Time(10,0,0),
                new Time(11,0,0));

        //then
        Assert.assertTrue(reservationValidator.isReservationTakenValidation(reservation,reservationToValid));

        //given
        //new reservation starts after reservation
        reservationToValid.setStart(new Time(12,0,0));
        reservationToValid.setEnd(new Time(13,0,0));
        //then
        Assert.assertTrue(reservationValidator.isReservationTakenValidation(reservation,reservationToValid));

        //given
        //new reservation ends in reservation
        reservationToValid.setStart(new Time(10,30,0));
        reservationToValid.setEnd(new Time(11,30,0));
        //then
        Assert.assertFalse(reservationValidator.isReservationTakenValidation(reservation,reservationToValid));

        //given
        //new reservation starts in reservation
        reservationToValid.setStart(new Time(11,30,0));
        reservationToValid.setEnd(new Time(12,30,0));
        //then
        Assert.assertFalse(reservationValidator.isReservationTakenValidation(reservation,reservationToValid));

        //given
        //new reservation in reservation
        reservationToValid.setStart(new Time(11,15,0));
        reservationToValid.setEnd(new Time(11,45,0));
        //then
        Assert.assertFalse(reservationValidator.isReservationTakenValidation(reservation,reservationToValid));

        //given
        //new reservation starts after end
        reservationToValid.setStart(new Time(11,45,0));
        reservationToValid.setEnd(new Time(11,15,0));
        //then
        Assert.assertFalse(reservationValidator.isReservationTakenValidation(reservation,reservationToValid));
    }


    private List<Reservation> mockReservations()
    {
        List<Reservation> reservationList = new ArrayList<>();
        //ReservationForm reservation_= new ReservationForm(null,
         //       null, new Time(11,0,0),
         //       new Time(12,0,0));
        //Reservation reservation = new Reservation(reservation_,null,null);

        reservationList.add(new Reservation());
        reservationList.add(new Reservation());
        return reservationList;
    }



    @Test
    void testIsReservationTaken() {
        //given
        ReservationForm reservationToValid = new ReservationForm(null,
                null, new Time(10,0,0),
                new Time(11,0,0));

            Court cort = mock(Court.class);
        //when
        when(reservationsRepository.findByDayAndCort(reservationToValid.getDay(),cort ))
                .thenReturn(Collections.emptyList());
        //then
        Assert.assertTrue(reservationValidator.isReservationTaken(reservationToValid, cort));


        /*
        //when
        when(reservationsRepository.findByDayAndCort(reservationToValid.getDay(),cort ))
                .thenReturn(mockReservations());
        when(this.reservationValidator.isReservationTakenValidation(any(Reservation.class),any(ReservationForm.class)))
                .thenReturn(true);
        //then
        Assert.assertTrue(reservationValidator.isReservationTaken(reservationToValid, cort));
         */


    }



}
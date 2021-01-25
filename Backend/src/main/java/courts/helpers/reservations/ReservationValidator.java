package courts.helpers.reservations;

import courts.dto.reservations.ReservationDto;
import courts.exception.ConflictException;
import courts.exception.NotFoundException;
import courts.models.Court;
import courts.models.openingHour.OpeningHour;
import courts.models.openingHour.SpecialOpeningHour;
import courts.models.reservation.Reservation;
import courts.repositories.openingHours.IClosingDaysRepository;
import courts.repositories.openingHours.IOpeningHoursRepository;
import courts.repositories.openingHours.ISpecialOpeningHoursRepository;
import courts.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Component
public class ReservationValidator implements IReservationValidator {

    @Autowired
    private ReservationsRepository reservationsRepository;

    @Autowired
    private IOpeningHoursRepository openingHoursRepository;

    @Autowired
    private ISpecialOpeningHoursRepository specialOpeningHoursRepository;

    @Autowired
    private IClosingDaysRepository closingDaysRepository;

    @Override
    public boolean validateReservation(ReservationDto reservation, Court cort) throws ConflictException {
        if (checkClosingDays(reservation))
            return false;
        if (isReservationTaken(reservation,cort) && isCortOpen(reservation))
        {
            return true;
        }
        throw new ConflictException("Reservation not valid");
    }

    boolean isCortOpen(ReservationDto reservation) throws ConflictException {
        int check = checkSpecialOpeningHours(reservation);
        if(check == 1)
            throw new ConflictException("Court is closed");
        else if(check == 2)
            return true;
        if (check == 0) {
            return  checkOpeningHours(reservation);
        }
        throw new ConflictException("Court is closed");
    }

    boolean checkOpeningHours(ReservationDto reservation) throws ConflictException {
        java.util.GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();
        cal.setTime(reservation.getDay());
        int day = cal.get(java.util.Calendar.DAY_OF_WEEK) - 1;

        Optional<OpeningHour> openingHourFromDB = openingHoursRepository.findByDay(day);

        if (openingHourFromDB.isPresent()) {
            if (openingHourFromDB.get().getOpen()) {

                OpeningHour o = openingHourFromDB.get();
                if (o.getStart().getTime() <= reservation.getStart().getTime()
                        && o.getEnd().getTime() >= reservation.getEnd().getTime()) {
                    return true;
                }
            }
        }
        throw new ConflictException("Court is closed");
    }


    int checkSpecialOpeningHours(ReservationDto reservation)
    {
        Optional<SpecialOpeningHour> specialOpeningHour = specialOpeningHoursRepository.findByDay(reservation.getDay());
        if (specialOpeningHour.isPresent())
        {
            SpecialOpeningHour o = specialOpeningHour.get();
            if (o.getStart().getTime()<=reservation.getStart().getTime()
                    && o.getEnd().getTime()>=reservation.getEnd().getTime())
            {
                return 2;
            }
            else return 1;
        }
        return 0;
    }
    boolean checkClosingDays (ReservationDto reservation) throws ConflictException {
        if(closingDaysRepository.findByDay(reservation.getDay()).isPresent())
        {
            throw new ConflictException("Court is closed");
        }
        return false;
    }


    boolean isReservationTaken(ReservationDto reservationToValidate, Court cort) throws ConflictException {
        List<Reservation>reservationList=reservationsRepository.findByDayAndCort(reservationToValidate.getDay(), cort);
        for (Reservation r: reservationList){
            if(!isReservationTakenValidation(r, reservationToValidate))
                return false;
        }
        return true;
    }

    boolean isReservationTakenValidation(Reservation reservation, ReservationDto reservationToValidate) throws ConflictException {
        if (reservationToValidate.getStart().getTime()<reservationToValidate.getEnd().getTime())
        {
            if(reservationToValidate.getEnd().getTime()<= reservation.getStart().getTime()
                    || reservationToValidate.getStart().getTime()>=reservation.getEnd().getTime()){
                return true;
            }
        }
        else
        {
            throw new ConflictException("Reservation can not start after end ");
        }
        throw new ConflictException("In this hours exist another reservation");
    }


}

package courts.helpers.reservations;

import courts.dto.reservations.ReservationDto;
import courts.exception.ConflictException;
import courts.models.Court;

public interface IReservationValidator {
    public abstract boolean validateReservation(ReservationDto reservation, Court cort) throws ConflictException;
}

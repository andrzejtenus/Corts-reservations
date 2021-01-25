package courts.interfaces;

import courts.dto.reservations.ReservationDto;
import courts.exception.ConflictException;
import courts.exception.NotFoundException;
import courts.models.reservation.ReservationStatus;

import java.util.List;

public interface IReservationsService {
    public abstract List<ReservationDto> getAllReservations();

    public abstract ReservationDto addReservation(ReservationDto model, Long userId) throws NotFoundException, ConflictException;

    public abstract ReservationDto changeReservationStatus(Integer id, ReservationStatus status) throws NotFoundException;

    public abstract List<ReservationDto> getUserReservations(Long userId);
}

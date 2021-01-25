package courts.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import courts.dto.reservations.ReservationDto;
import courts.exception.ConflictException;
import courts.exception.NotFoundException;
import courts.helpers.reservations.IReservationValidator;
import courts.interfaces.IReservationsService;
import courts.models.Court;
import courts.models.reservation.Reservation;
import courts.models.reservation.ReservationStatus;
import courts.models.roles.User;
import courts.repositories.ICortsRepository;
import courts.repositories.ReservationsRepository;
import courts.repositories.roles.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ReservationServiceImpl implements IReservationsService {

    @Autowired
    ReservationsRepository reservationsRepository;

    @Autowired
    ICortsRepository courtsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ObjectMapper objectMapper;


    @Autowired
    IReservationValidator reservationHelper;


    @Override
    public List<ReservationDto> getAllReservations() {
        return reservationsRepository.findAll().stream()
                .map(ReservationDto::new).collect(Collectors.toList());
    }

    @Override
    public ReservationDto addReservation(ReservationDto model, Long userId) throws NotFoundException, ConflictException {
        Optional<Court> cortFromDb = courtsRepository.findById(model.getCourtId());
        Optional<User> userFromDb = userRepository.findById(userId);


        if (cortFromDb.isPresent()) {
            if (userFromDb.isPresent()) {
                if (reservationHelper.validateReservation(model, cortFromDb.get())) {
                    Reservation object = new Reservation(model, userFromDb.get(), cortFromDb.get());
                    return new ReservationDto(reservationsRepository.save(object));
                }
            }
            else {
                throw new NotFoundException("User not found");
            }
        }
        else{
            throw new NotFoundException("Court not found");
        }
        throw new ConflictException("Reservation not valid");
    }

    @Override
    public ReservationDto changeReservationStatus(Integer id, ReservationStatus status) throws NotFoundException {
        Optional<Reservation> reservation = reservationsRepository.findById(id);
        if (reservation.isPresent())
        {
            reservation.get().setReservationStatus(status);
            return new ReservationDto(reservationsRepository.save(reservation.get()));
        }
        throw new NotFoundException("Reservation not found");
    }

    @Override
    public List<ReservationDto> getUserReservations(Long userId) {

        Optional<User> user = userRepository.findById(userId);
        return reservationsRepository.findByUser(user.get()).stream()
                .map(ReservationDto::new).collect(Collectors.toList());
    }

}

package courts.repositories;

import courts.models.Court;
import courts.models.reservation.Reservation;
import courts.models.roles.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationsRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByDayAndCort (java.sql.Timestamp day, Court cort);
    List<Reservation> findByUser (User user);
    Optional<Reservation>findById(java.lang.Integer id);
}

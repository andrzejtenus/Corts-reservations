package courts.repositories.openingHours;

import courts.models.openingHour.SpecialOpeningHour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ISpecialOpeningHoursRepository extends JpaRepository<SpecialOpeningHour, Long> {
    Optional<SpecialOpeningHour> findByDay(java.sql.Timestamp day);
    Optional<SpecialOpeningHour> findById(java.lang.Integer id );
}

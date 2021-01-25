package courts.repositories.openingHours;

import courts.models.openingHour.OpeningHour;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface IOpeningHoursRepository extends JpaRepository<OpeningHour, Long> {
    Optional<OpeningHour> findByDay(java.lang.Integer day);
    List<OpeningHour> findById(java.lang.Integer id);
}

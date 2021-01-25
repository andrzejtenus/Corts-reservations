package courts.repositories.openingHours;

import courts.models.openingHour.ClosingDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClosingDaysRepository extends JpaRepository<ClosingDay,Long> {
    Optional<ClosingDay> findByDay (java.sql.Timestamp day);
    Optional<ClosingDay> findById (java.lang.Integer id);
}

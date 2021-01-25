package courts.repositories;

import courts.models.Court;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICortsRepository extends JpaRepository<Court, Long> {
    Optional<Court> findById (java.lang.Integer id);
    Optional<Court> findByLabel (char[] label);
}

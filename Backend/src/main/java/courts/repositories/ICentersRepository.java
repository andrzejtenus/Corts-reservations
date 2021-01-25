package courts.repositories;

import courts.models.Center;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICentersRepository extends JpaRepository<Center,Long> {
    Optional<Center> findByName (char[] name);
    Optional<Center> findById (java.lang.Integer id);
}

package courts.services.openingHours;

import courts.interfaces.openingHours.IOpeningHoursService;
import courts.models.openingHour.OpeningHour;
import courts.repositories.openingHours.IOpeningHoursRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ActiveProfiles("H2")
class OpeningHourServiceTest {

    @Autowired
    IOpeningHoursService openingHoursService;

    @Autowired
    IOpeningHoursRepository openingHoursRepository;

    @AfterEach
    void tearDown() {
        openingHoursRepository.deleteAll();
    }

    @Test
    void getAllOpeningHours() {
        OpeningHour openingHour = new OpeningHour(1,new Time(1),new Time(2),true);
        assertEquals(0, openingHoursRepository.count());
        openingHoursRepository.save(openingHour);
        assertEquals(1, openingHoursRepository.count());
    }

    @Test
    void changeOpeningHour() {
    }
}
package courts.interfaces.openingHours;

import courts.dto.openingHours.OpeningHourDto;
import courts.exception.NotFoundException;
import courts.models.openingHour.OpeningHour;

import java.util.List;

public interface IOpeningHoursService {

    public abstract List<OpeningHour> getAllOpeningHours();
    public abstract OpeningHour changeOpeningHour(OpeningHourDto model) throws NotFoundException;
}

package courts.interfaces.openingHours;

import courts.dto.openingHours.ClosingDayDto;
import courts.exception.ConflictException;
import courts.exception.NotFoundException;
import courts.models.openingHour.ClosingDay;

import java.util.List;

public interface IClosingDaysService {

    public abstract List<ClosingDay> getAllClosingDays();

    public abstract ClosingDay addClosingDay(ClosingDayDto model) throws ConflictException;

    public abstract boolean deleteClosingDay(final Integer id) throws NotFoundException;
}

package courts.interfaces.openingHours;

import courts.dto.openingHours.SpecialOpeningHourDto;
import courts.exception.ConflictException;
import courts.exception.NotFoundException;
import courts.models.openingHour.SpecialOpeningHour;

import java.util.List;

public interface ISpecialOpeningHoursService {

    public abstract List<SpecialOpeningHour> getAllSpecialOpeningHours();

    public abstract SpecialOpeningHour addSpecialOpeningHour(SpecialOpeningHourDto model) throws ConflictException;

    public abstract SpecialOpeningHour changeSpecialOpeningHour(SpecialOpeningHourDto model) throws NotFoundException;

    public abstract boolean deleteSpecialOpeningHour(Integer id) throws NotFoundException;

}

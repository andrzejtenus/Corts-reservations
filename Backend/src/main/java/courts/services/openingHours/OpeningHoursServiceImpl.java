package courts.services.openingHours;

import courts.dto.openingHours.OpeningHourDto;
import courts.exception.ConflictException;
import courts.exception.NotFoundException;
import courts.interfaces.openingHours.IOpeningHoursService;
import courts.models.openingHour.OpeningHour;
import courts.repositories.openingHours.IOpeningHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OpeningHoursServiceImpl implements IOpeningHoursService {
    @Autowired
    IOpeningHoursRepository openingHoursRepository;

    @Override
    public List<OpeningHour> getAllOpeningHours()
    {
        return openingHoursRepository.findAll();
    }

    @Override
    public OpeningHour changeOpeningHour(OpeningHourDto model) throws NotFoundException {
        Optional<OpeningHour> OpeningHourFromDb = openingHoursRepository.findByDay(model.getDay());
        if(OpeningHourFromDb.isPresent())
        {
            OpeningHour o = OpeningHourFromDb.get();
            o.setStart(model.getStart());
            o.setEnd(model.getEnd());
            o.setOpen(model.getOpen());

            return openingHoursRepository.save(o);
        }
        throw new NotFoundException("Opening Hour day does not exists");
    }


}

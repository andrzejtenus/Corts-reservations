package courts.services.openingHours;

import courts.dto.openingHours.SpecialOpeningHourDto;
import courts.exception.ConflictException;
import courts.exception.NotFoundException;
import courts.interfaces.openingHours.ISpecialOpeningHoursService;
import courts.models.openingHour.SpecialOpeningHour;
import courts.repositories.openingHours.ISpecialOpeningHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialOpeningHourServiceImpl implements ISpecialOpeningHoursService {
    @Autowired
    ISpecialOpeningHoursRepository specialOpeningHoursRepository;

    @Override
    public List<SpecialOpeningHour> getAllSpecialOpeningHours() {
        return specialOpeningHoursRepository.findAll();
    }

    @Override
    public SpecialOpeningHour addSpecialOpeningHour(SpecialOpeningHourDto model) throws ConflictException {
        Optional<SpecialOpeningHour> specialOpeningHourFromDB = specialOpeningHoursRepository.findByDay(model.getDay());
        if (!specialOpeningHourFromDB.isPresent())
        {
            SpecialOpeningHour object = new SpecialOpeningHour(model);

            return specialOpeningHoursRepository.save(object);
        }
        throw new ConflictException("Special opening hour for this day already exists");
    }

    @Override
    public SpecialOpeningHour changeSpecialOpeningHour(SpecialOpeningHourDto model) throws NotFoundException {
        Optional<SpecialOpeningHour> specialOpeningHourFromDB = specialOpeningHoursRepository.findByDay(model.getDay());

        if (specialOpeningHourFromDB.isPresent())
        {
            specialOpeningHourFromDB.get().setDescription(model.getDescription());
            specialOpeningHourFromDB.get().setEnd(model.getEnd());
            specialOpeningHourFromDB.get().setStart(model.getStart());

            return specialOpeningHoursRepository.save(specialOpeningHourFromDB.get());
        }
        throw new NotFoundException("Special opening hour not found");
    }

    @Override
    public boolean deleteSpecialOpeningHour(Integer id) throws NotFoundException {
        Optional<SpecialOpeningHour>specialOpeningHourFromDB = specialOpeningHoursRepository.findById(id);
        if(specialOpeningHourFromDB.isPresent()) {
            specialOpeningHoursRepository.delete(specialOpeningHourFromDB.get());
            return true;
        }
        throw new NotFoundException("Special opening hour not exists");
    }

}


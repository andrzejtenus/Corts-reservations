package courts.services.openingHours;


import courts.dto.openingHours.ClosingDayDto;
import courts.exception.ConflictException;
import courts.exception.NotFoundException;
import courts.interfaces.openingHours.IClosingDaysService;
import courts.models.openingHour.ClosingDay;
import courts.repositories.openingHours.IClosingDaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClosingDaysServiceImpl implements IClosingDaysService {

    @Autowired
    IClosingDaysRepository closingDaysRepository;

    @Override
    public List<ClosingDay> getAllClosingDays()
    {
        List<ClosingDay> closingDayModelList = closingDaysRepository.findAll();
        return closingDayModelList;
    }

    @Override
    public ClosingDay addClosingDay(ClosingDayDto model) throws ConflictException {
        Optional<ClosingDay> dayFromDb = closingDaysRepository.findByDay(model.getDay());
        if (dayFromDb.isPresent())
        {
            throw new ConflictException("Closing day already exists");
        }
        else
        {
            ClosingDay object = new ClosingDay(model.getDay(), model.getDescription());

            return closingDaysRepository.save(object);
        }
    }

    @Override
    public boolean deleteClosingDay(final Integer id) throws NotFoundException {
        Optional<ClosingDay> dayFromDb = closingDaysRepository.findById(id);
        if(dayFromDb.isPresent()) {
            closingDaysRepository.delete(dayFromDb.get());
            return true;
        }
        throw new NotFoundException("Closing Day does not exists");
    }
}

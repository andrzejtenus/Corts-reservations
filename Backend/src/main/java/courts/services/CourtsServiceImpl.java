package courts.services;

import courts.dto.CourtDto;
import courts.exception.ConflictException;
import courts.exception.NotFoundException;
import courts.interfaces.ICourtsService;
import courts.models.Center;
import courts.models.Court;
import courts.repositories.ICentersRepository;
import courts.repositories.ICortsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourtsServiceImpl implements ICourtsService {
    @Autowired
    ICortsRepository cortsRepository;

    @Autowired
    ICentersRepository centersRepository;

    @Override
    public List<CourtDto> getAllCorts() {
        return cortsRepository.findAll().stream()
                .map(CourtDto::new).collect(Collectors.toList());
    }

    @Override
    public CourtDto addCort(CourtDto model) throws ConflictException {
        Optional<Center> centerFromDb = centersRepository.findById(model.getCenterid());
        if (centerFromDb.isPresent())
        {
            Court cort = new Court(model,centerFromDb.get());
            return new CourtDto(cortsRepository.save(cort));
        }
        else
        {
            throw new ConflictException("Court already exists");
        }
    }

}

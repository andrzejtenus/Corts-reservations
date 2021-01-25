package courts.services;

import courts.dto.CenterDto;
import courts.exception.ConflictException;
import courts.exception.NotFoundException;
import courts.interfaces.ICentersService;
import courts.models.Center;
import courts.repositories.ICentersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CentersServiceImpl implements ICentersService {

    @Autowired
    ICentersRepository centersRepository;

    @Override
    public List<CenterDto> getAllCenters() {

        return centersRepository.findAll().stream()
                .map(CenterDto::new).collect(Collectors.toList());
    }

    @Override
    public Center addCenter(CenterDto model) throws ConflictException {
        Optional<Center> centerFromDatabase = centersRepository.findByName(model.getName());
        if(centerFromDatabase.isPresent())
        {
            throw new ConflictException("Center already exists");
        }
        else
        {

            return centersRepository.save(new Center(model));
        }
    }

    @Override
    public Center changeCenter(CenterDto model) throws NotFoundException {
        Optional<Center> centerFromDatabase = centersRepository.findByName(model.getName());
        if(centerFromDatabase.isPresent())
        {
            centerFromDatabase.get().setActive(model.getActive());

            return centersRepository.save(centerFromDatabase.get());
        }
        else
        {
            throw new NotFoundException("Center bot found");
        }
    }

}

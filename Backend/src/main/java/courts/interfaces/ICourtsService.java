package courts.interfaces;

import courts.dto.CourtDto;
import courts.exception.ConflictException;

import java.util.List;

public interface ICourtsService {
    public abstract List<CourtDto> getAllCorts();

    public abstract CourtDto addCort(CourtDto model) throws ConflictException;

}

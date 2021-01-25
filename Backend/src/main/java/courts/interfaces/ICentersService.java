package courts.interfaces;

import courts.dto.CenterDto;
import courts.exception.ConflictException;
import courts.exception.NotFoundException;
import courts.models.Center;

import java.util.List;

public interface ICentersService {
    public abstract List<CenterDto> getAllCenters();

    public abstract Center addCenter(CenterDto model) throws ConflictException;

    public abstract Center changeCenter(CenterDto model) throws NotFoundException;

}

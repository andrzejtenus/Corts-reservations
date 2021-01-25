package courts.controllers.openingHours;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import courts.dto.openingHours.SpecialOpeningHourDto;
import courts.exception.ConflictException;
import courts.exception.NotFoundException;
import courts.interfaces.openingHours.ISpecialOpeningHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/special_opening_hours")
@PreAuthorize("hasRole('ADMIN')")
@ResponseBody
public class SpecialOpeningHoursController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ISpecialOpeningHoursService specialOpeningHoursService;

    @GetMapping
    public ResponseEntity getSpecialOpeningHours() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(specialOpeningHoursService.getAllSpecialOpeningHours()));
    }
    @PostMapping
    public ResponseEntity addSpecialOpeningHours(@Valid @RequestBody  SpecialOpeningHourDto model)
            throws ConflictException {
        return ResponseEntity.ok(specialOpeningHoursService.addSpecialOpeningHour(model));
    }

    @PutMapping
    public ResponseEntity putSpecialOpeningHour(@Valid @RequestBody SpecialOpeningHourDto model)
            throws NotFoundException {
        return ResponseEntity.ok(specialOpeningHoursService.changeSpecialOpeningHour(model));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteSpecialOpeningHour(@PathVariable("id") Integer id) throws NotFoundException {
        if(specialOpeningHoursService.deleteSpecialOpeningHour(id))
            return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}


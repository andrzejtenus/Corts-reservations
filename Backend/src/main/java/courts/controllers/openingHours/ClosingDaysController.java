package courts.controllers.openingHours;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import courts.dto.openingHours.ClosingDayDto;
import courts.exception.ConflictException;
import courts.exception.NotFoundException;
import courts.interfaces.openingHours.IClosingDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/closing_days")
@PreAuthorize("hasRole('ADMIN')")
@ResponseBody
public class ClosingDaysController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    IClosingDaysService closingDaysService;

    @GetMapping
    public ResponseEntity getClosingDays() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(closingDaysService.getAllClosingDays()));
    }
    @PostMapping
    public ResponseEntity postClosingDays(@Valid @RequestBody ClosingDayDto model) throws ConflictException {
       return ResponseEntity.ok(closingDaysService.addClosingDay(model));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteClosingDays(@PathVariable("id") final Integer id) throws NotFoundException {

        if(closingDaysService.deleteClosingDay(id))
            return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.CONFLICT).build();

    }


}

package courts.controllers.openingHours;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import courts.dto.openingHours.OpeningHourDto;
import courts.exception.NotFoundException;
import courts.interfaces.openingHours.IOpeningHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/opening_hours")
@PreAuthorize("hasRole('ADMIN')")
@ResponseBody
public class OpeningHoursController {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    IOpeningHoursService openingHoursService;

    @GetMapping
    public ResponseEntity getAllOpeningHours() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(openingHoursService.getAllOpeningHours()));
    }

    @PutMapping
    public ResponseEntity putOpeningHour(@Valid @RequestBody OpeningHourDto model)
            throws NotFoundException {
        return ResponseEntity.ok(openingHoursService.changeOpeningHour(model));
    }
}

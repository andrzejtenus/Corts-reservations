package courts.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import courts.dto.CourtDto;
import courts.exception.ConflictException;
import courts.interfaces.ICourtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/courts")
@PreAuthorize("hasRole('ADMIN')")
@ResponseBody
public class CortsControler {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ICourtsService cortsService;

    @GetMapping
    public ResponseEntity getCourts() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(cortsService.getAllCorts()));
    }

    @PostMapping
    public ResponseEntity postCourts(@Valid @RequestBody CourtDto model) throws ConflictException {
        return ResponseEntity.ok(cortsService.addCort(model));
    }
}

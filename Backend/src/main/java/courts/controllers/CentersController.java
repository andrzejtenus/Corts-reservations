package courts.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import courts.dto.CenterDto;
import courts.exception.ConflictException;
import courts.exception.NotFoundException;
import courts.interfaces.ICentersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/centers")
@PreAuthorize("hasRole('ADMIN')")
@ResponseBody
public class CentersController {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ICentersService centersService;

    @GetMapping
    public ResponseEntity getCenters() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(centersService.getAllCenters()));
    }
    @PutMapping
    public ResponseEntity putCenters(@Valid @RequestBody CenterDto model) throws NotFoundException {
        return ResponseEntity.ok(centersService.changeCenter(model));
    }
    @PostMapping
    public ResponseEntity postCenters(@Valid @RequestBody CenterDto model) throws ConflictException {
        return ResponseEntity.ok(centersService.addCenter(model));
    }
}

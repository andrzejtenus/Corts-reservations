package courts.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import courts.authorisation.JwtProvider;

import courts.dto.reservations.ReservationDto;
import courts.exception.ConflictException;
import courts.exception.NotFoundException;
import courts.interfaces.IReservationsService;

import courts.models.reservation.ReservationStatus;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/reservations")
@ResponseBody
public class ReservationsController {


    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    IReservationsService reservationService;

    @Autowired
    ObjectMapper objectMapper;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity getAllReservations() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(reservationService.getAllReservations()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity getUserReservations(@PathVariable("id") final  Long id) throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(reservationService.getUserReservations(id)));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity postReservation(@Valid @RequestBody ReservationDto model
            , @RequestHeader (name="Authorization") String token ) throws NotFoundException, ConflictException {
        Long userId=jwtProvider.getUserIdFromToken(token.replace("Bearer ",""));
        return ResponseEntity.ok(reservationService.addReservation(model, userId));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public ResponseEntity getOwnReservations(@RequestHeader (name="Authorization") String token) throws JsonProcessingException {
        Long userId = jwtProvider.getUserIdFromToken(token.replace("Bearer ",""));
        return ResponseEntity.ok(objectMapper.writeValueAsString(reservationService.getUserReservations(userId)));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity changeReservationStatus(@PathVariable("id") final  Integer id
            , @RequestBody String status) throws NotFoundException {
        return ResponseEntity.ok(reservationService.changeReservationStatus(id, ReservationStatus.valueOf(status)));
    }


}

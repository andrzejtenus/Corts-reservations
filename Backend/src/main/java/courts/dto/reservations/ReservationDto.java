package courts.dto.reservations;

import courts.models.reservation.Reservation;
import courts.models.reservation.ReservationStatus;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.sql.Timestamp;

public class ReservationDto {

    private java.lang.Integer id;

    private Long userId;

    @NotNull(message = "Court id can not be empty")
    private java.lang.Integer courtId;

    @NotNull(message = "Day can not be empty")
    @Future(message = "Day must be in future")
    private java.sql.Timestamp day;

    @NotNull(message = "Start can not be empty")
    private java.sql.Time start;

    @NotNull(message = "End can not be empty")
    private java.sql.Time end;

    ReservationStatus reservationStatus;

    public Integer getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getCourtId() {
        return courtId;
    }

    public Timestamp getDay() {
        return day;
    }

    public Time getStart() {
        return start;
    }

    public Time getEnd() {
        return end;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public ReservationDto(Reservation model) {
        this.id = model.getId();
        this.userId = model.getUser().getId();
        this.courtId = model.getCort().getId();
        this.day = model.getDay();
        this.start = model.getStart();
        this.end = model.getEnd();
        this.reservationStatus = model.getReservationStatus();
    }

    public ReservationDto() {
    }
}

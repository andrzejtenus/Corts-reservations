package courts.models.reservation;

import courts.dto.reservations.ReservationDto;
import courts.models.Court;
import courts.models.roles.User;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

import static courts.models.reservation.ReservationStatus.ACTIVE;

@Entity
@Table(name = "Reservations")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private java.lang.Integer id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable=false)
    User user;


    @ManyToOne
    @JoinColumn(name = "cortId", referencedColumnName = "id", nullable=false)
    Court cort;

    @NonNull
    @Column(nullable = false)
    private java.sql.Timestamp day;

    @NonNull
    @Column(nullable = false)
    private java.sql.Time start;

    @NonNull
    @Column(nullable = false)
    private java.sql.Time end;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ReservationStatus reservationStatus;

    public Reservation() {
    }

    public Integer getId() {
        return id;
    }

    public Reservation(ReservationDto model, User user, Court cort)
    {
        this.cort= cort;
        this.user=user;
        this.day= model.getDay();
        this.start= model.getStart();
        this.end=model.getEnd();
        this.reservationStatus=ACTIVE;
    }

    public User getUser() {
        return user;
    }

    public Court getCort() {
        return cort;
    }

    public Timestamp getDay() {
        return day;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
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
}

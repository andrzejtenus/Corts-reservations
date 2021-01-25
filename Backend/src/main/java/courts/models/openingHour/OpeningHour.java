package courts.models.openingHour;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "OpeningHours")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class OpeningHour {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private java.lang.Integer id;

    @NonNull
    @Column(nullable = false)
    private java.lang.Integer day;

    @NonNull
    @Column(nullable = false)
    private java.sql.Time start;

    @NonNull
    @Column(nullable = false)
    private java.sql.Time end;

    @NonNull
    @Column(nullable = false)
    private java.lang.Boolean open;

    public Integer getDay() {
        return day;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Integer getId() {
        return id;
    }

    public OpeningHour() {
    }

    public OpeningHour(Integer day, Time start, Time end, Boolean open) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.open = open;
    }
}

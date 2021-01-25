package courts.models.openingHour;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ClosingDays")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class ClosingDay {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private java.lang.Integer id;

    @NonNull
    @Column(nullable = false)
    private java.sql.Timestamp day;

    public ClosingDay(Timestamp day, char[] description) {
        this.day = day;
        this.description = description;
    }

    public ClosingDay() {
    }

    private char[] description;

    public Timestamp getDay() {
        return day;
    }

    public void setDay(Timestamp day) {
        this.day = day;
    }

    public void setDescription(char[] description) {
        this.description = description;
    }
}

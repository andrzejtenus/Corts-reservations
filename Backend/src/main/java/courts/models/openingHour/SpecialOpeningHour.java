package courts.models.openingHour;


import courts.dto.openingHours.SpecialOpeningHourDto;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "SpecialOpeningHours")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class SpecialOpeningHour {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(nullable = false)
    private java.sql.Timestamp day;

    @NonNull
    @Column(nullable = false)
    private java.sql.Time start;


    @NonNull
    @Column(nullable = false)
    private java.sql.Time end;

    private char[] description;

    public SpecialOpeningHour(SpecialOpeningHourDto model)
    {
        this.day = model.getDay();
        this.end=model.getEnd();
        this.start=model.getStart();
        this.description=model.getDescription();

    }

    public SpecialOpeningHour() {
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public void setDescription(char[] description) {
        this.description = description;
    }

    public Time getStart() {
        return start;
    }

    public Time getEnd() {
        return end;
    }
}

package courts.dto.openingHours;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.sql.Timestamp;

public class SpecialOpeningHourDto {

    @NotNull(message = "Day can not be empty")
    @Future(message = "Day must be in future")
    private java.sql.Timestamp day;
    @NotNull(message = "Start can not be empty")
    private java.sql.Time start;
    @NotNull(message = "End can not be empty")
    private java.sql.Time end;

    private char[] description;

    public Timestamp getDay() {
        return day;
    }

    public Time getStart() {
        return start;
    }

    public Time getEnd() {
        return end;
    }

    public char[] getDescription() {
        return description;
    }
}

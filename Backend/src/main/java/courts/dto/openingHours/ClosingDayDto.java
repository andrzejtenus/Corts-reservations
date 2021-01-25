package courts.dto.openingHours;


import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import java.sql.Timestamp;

public class ClosingDayDto {


    @NotNull(message = "Day can not be empty")
    @Future(message = "Day must be in future")
    private java.sql.Timestamp day;

    private char[] description;

    public Timestamp getDay() {
        return day;
    }


    public char[] getDescription() {
        return description;
    }

}
